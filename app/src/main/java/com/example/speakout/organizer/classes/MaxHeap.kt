package com.example.speakout.organizer.classes

import com.example.speakout.utils.Helper

class MaxHeap
{
    private var length:Int=0
    private val heap:ArrayList<QuestionClass> = ArrayList()
    // implement all logic for selecting the first n questions
    fun insert(question: QuestionClass)
    {
        if(length==0)
        {
            heap.add(question)
            length++;
        }
        else
        {
            heap.add(question)
            var index:Int=length
            while(greater(
                    heap[index].getVotes(), heap[parent(index)].getVotes()
                    , heap[index].getNumberOfComments(), heap[parent(index)].getNumberOfComments()) && index!=0)
            {
                var t:QuestionClass= heap[index]
                heap[index] = heap[parent(index)]
                heap[parent(index)] = t
                index=parent(index)
            }
            length++
        }
    }

    fun deleteHeapify(i:Int)
    {
        if(heap.isNotEmpty())
        {
            var l=left(i)
            var r=right(i)
            if(l<length && r >= length)
            {
                if(greater(heap[l].getVotes(),heap[i].getVotes(),heap[l].getNumberOfComments(),heap[i].getNumberOfComments()))
                {
                    val t=heap[l]
                    heap[l]=heap[i]
                    heap[i]=t
                    deleteHeapify(l)
                }
            }
            else if (l<length && r<length)
            {
                if(greater(heap[l].getVotes(),heap[i].getVotes(),heap[l].getNumberOfComments(),heap[i].getNumberOfComments())
                    || greater(heap[r].getVotes(),heap[i].getVotes(),heap[r].getNumberOfComments(),heap[i].getNumberOfComments()))
                {
                    if(greater(heap[l].getVotes(),heap[r].getVotes(),heap[l].getNumberOfComments(),heap[r].getNumberOfComments()))
                    {
                        val t=heap[l]
                        heap[l]=heap[i]
                        heap[i]=t
                        deleteHeapify(l)
                    }
                    else
                    {
                        val t=heap[r]
                        heap[r]=heap[i]
                        heap[i]=t
                        deleteHeapify(r)
                    }
                }
            }
        }
    }
    fun removeMax():QuestionClass
    {
        if(heap.isNotEmpty())
        {
            val q:QuestionClass= heap[0]
            heap[0]=heap[length-1]
            heap.removeAt(length-1)
            length--
            deleteHeapify(0)
            return q
        }
        return QuestionClass("NotFound","","","","","")
    }
    fun get(i:Int):ArrayList<QuestionClass> // return a list
    {
        var out:ArrayList<QuestionClass> = ArrayList()
        for(i in 1..i)
        {
            out.add(removeMax())
        }
        return out
    }
    fun left(i:Int)=(i*2)+1
    fun right(i:Int)=(i*2)+2
    fun parent(i:Int)=(i-1)/2
    fun greater(v11:String?,v22:String?,c11:String?,c22:String?):Boolean
    {
        var v1=Helper.toInteger(v11)
        var v2=Helper.toInteger(v22)
        var c1=Helper.toInteger(c11)
        var c2=Helper.toInteger(c22)
        if(v1>=v2)
        {
            return true
        }
        else if(v2>v1)
        {
            return false
        }
        else return c1>=c2
    }

    fun geList()=heap

}