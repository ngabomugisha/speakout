package com.example.speakout.organizer.recycler_views

import android.content.Context
import android.graphics.Canvas
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.speakout.R
import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator
import java.security.AccessController.getContext


abstract class SwipeToUpvoteCallback: ItemTouchHelper.Callback()
{
    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ):Int {
        val swipeFlag = ItemTouchHelper.LEFT
        return makeMovementFlags(0,swipeFlag)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ):Boolean{
        return false
    }


//
//    val backgroundColor = ContextCompat.getColor(context, R.color.design_default_color_primary_variant)
//    override fun onMove(
//        recyclerView: RecyclerView,
//        viewHolder: RecyclerView.ViewHolder,
//        target: RecyclerView.ViewHolder
//    ): Boolean {
//        Log.d("!!!!!!!!!", "SWIPEEEEDDDD")
//        return false
//    }
//
//
//
//    override fun onChildDraw(
//        c: Canvas,
//        recyclerView: RecyclerView,
//        viewHolder: RecyclerView.ViewHolder,
//        dX: Float,
//        dY: Float,
//        actionState: Int,
//        isCurrentlyActive: Boolean
//    ) {
//        RecyclerViewSwipeDecorator.Builder(
//            c,
//            recyclerView,
//            viewHolder,
//            dX,
//            dY,
//            actionState,
//            isCurrentlyActive
//        )
//            .addBackgroundColor(backgroundColor)
//            .addActionIcon(R.drawable.ic_vote)
//            .create()
//            .decorate()
//        super.onChildDraw(c, recyclerView, viewHolder, dX/5, dY, actionState, isCurrentlyActive)
//    }

}