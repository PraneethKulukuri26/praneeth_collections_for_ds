package data_structure;

import java.util.function.Consumer;

public class LinkedList<T> implements Cloneable{
	
	private node head=null;
	
	public void add(T t) {
		node NEW=new node();
		NEW.key=t;
		NEW.next=null;
		if(head==null){
			head=NEW;
		}else {
			node temp=head;
			while(temp.next!=null){
				temp=temp.next;
			}
			temp.next=NEW;
		}
	}
	
	public void addAtFirst(T t){
		node NEW=new node();
		NEW.key=t;
		if(head==null){
			head=NEW;
		}
		else {
			NEW.next=head;
			head=NEW;
		}
	}
	
	public void addAtLast(T t){
		add(t);
	}
	
	public void add(int index,T t) throws RuntimeException {
		int len=size();
		if(index==0)
			addAtFirst(t);
		else if(index==len)
			addAtLast(t);
		else if(index>=len)
			throw new RuntimeException ("IndexOutOfBoundException");
		else {
			int i=0;
			node temp=head,NEW=new node();
			NEW.key=t;
			while(i<index-1) {
				temp=temp.next;
				i++;
			}
			NEW.next=temp.next;
			temp.next=NEW;
		}
	}
	
	public void remove() throws RuntimeException
	{
		if(head==null)
			throw new RuntimeException("EmptyLinkedList");
		else {
			if(head.next==null)
				head=null;
			else {
				head=head.next;
			}
		}
	}
	
	public void removeAtFirst()
	{
		remove();
	}
	
	public void removeAtLast() throws RuntimeException {
		if(head==null)
			throw new RuntimeException("EmptyLinkedList");
		else {
			if(head.next==null)
				head=null;
			else {
				node temp=head;
				while(temp.next.next!=null)
				{
					temp=temp.next;
				}
				temp.next=null;
			}
		}
	}
	
	public void remove(int index)
	{
		int len=size();
		if(head==null)
			throw new RuntimeException("EmptyLinkedList");
		else if(index==0)
		{
			remove();
		}
		else if(index==len-1)
			removeAtLast();
		else if(index>=len)
			throw new RuntimeException ("IndexOutOfBoundException");
		else {
			int i=0;
			node temp=head;
			while(i<index-1)
			{
				temp=temp.next;
			}
			temp.next=temp.next.next;
		}
	}
		
	public int size(){
		int cou=0;
		for(node temp=head;temp!=null;temp=temp.next){
			cou++;
		}
		return cou;
	}
	
	public void forEach(Consumer<? super T> action)
	{
		for(node temp=head;temp!=null;temp=temp.next)
		{
			action.accept(temp.key);
		}
	}
	
	public void display(){
		for(node temp=head;temp!=null;temp=temp.next){
			System.out.print(temp.key+",");
		}
	}
	
	public void clear()
	{
		head=null;
	}

	
	private class node{
		T key;
		node next;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
