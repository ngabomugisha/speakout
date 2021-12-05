package com.example.speakout.general.classess

import androidx.appcompat.widget.ThemedSpinnerAdapter
import com.example.speakout.utils.Helper

/**
 * Comment.kt is a class for commenting on a post
 *
 * @author GeekPrideSoft (Maurice, Robert, Jean Paul, Venant)
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized
 * assistance on this work.
 *
 */
class Comment(private var comment_id:Int, private var comment_content:String, private var commenter:String,
private var townhall:Int, private var date:String,private var parent:Int)
{
    fun getCommentId()=comment_id
    fun getCommentContent()=comment_content
    fun getCommenter()=commenter
    fun getQuestion()=townhall
    fun getDate()=date
    fun getParent()=parent

    override fun toString(): String
    {
        return "ID:$comment_id, Content:$comment_content, Commenter:$commenter, Question:$townhall, Parent:$parent"
    }
}