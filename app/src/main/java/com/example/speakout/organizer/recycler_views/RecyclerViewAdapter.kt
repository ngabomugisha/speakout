package com.example.speakout.organizer.recycler_views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.speakout.R
import com.example.speakout.organizer.classes.TownHallViewClass
import com.google.firebase.database.ValueEventListener

class RecyclerViewTownHallAdapter(private var town_halls: ArrayList<TownHallViewClass>,
                                  private var listener: OnItemCLickListener
) :
    RecyclerView.Adapter<RecyclerViewTownHallAdapter.RecyclerViewTownHallHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewTownHallHolder {
        val view: View= LayoutInflater.from(parent.context).inflate(R.layout.town_hall_card_view, parent,false);
        return RecyclerViewTownHallHolder(view);
    }

    override fun onBindViewHolder(holder: RecyclerViewTownHallHolder, position: Int) {
        holder.bind(town_halls.get(position));
    }

    override fun getItemCount(): Int {
        return this.town_halls.size;
    }


    inner class RecyclerViewTownHallHolder (itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener
    {
        private lateinit var hall_name: TextView;
        private lateinit var hall_date: TextView;

        init {
            itemView.setOnClickListener(this)
        }
        fun bind(hall : TownHallViewClass)
        {
            hall_name=itemView.findViewById(R.id.hall_name_txtvw_id)
            hall_date=itemView.findViewById(R.id.hall_date_txtvw_id)
            hall_name.text=hall.getName();
            hall_date.text=hall.getDate();
        }

        override fun onClick(v: View?)
        {
            val position=adapterPosition
            if(position != RecyclerView.NO_POSITION)
            {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemCLickListener{
        fun onItemClick(position: Int)
    }


}
