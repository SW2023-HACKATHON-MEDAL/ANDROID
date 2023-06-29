package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.dto.medicine

class MainAdapter(
    var medicineList: List<medicine>,
    val inflater: LayoutInflater
) : RecyclerView.Adapter<MainAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView
        val color: TextView

        init {
            name = itemView.findViewById(R.id.medicineName)
            color = itemView.findViewById(R.id.medicineColor)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.listview_component, parent, false)
        return ViewHolder(view)
    }

    // 전체 데이터 수 반환
    override fun getItemCount(): Int {
        return medicineList.size
    }

    // ViewHolder 안의 내용을 position 에 해당하는 데이터로 교체
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.setText(medicineList.get(position).name)
        holder.color.setText(medicineList.get(position).color)
    }
}