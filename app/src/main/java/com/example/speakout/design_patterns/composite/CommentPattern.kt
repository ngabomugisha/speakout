package com.example.speakout.design_patterns.composite

import com.example.speakout.general.classess.Question
import org.w3c.dom.Comment

class CommentPattern(private var comment:Question)
{
    private var subComments:ArrayList<Question>?=null
}