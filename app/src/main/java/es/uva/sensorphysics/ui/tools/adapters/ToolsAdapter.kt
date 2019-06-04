package es.uva.sensorphysics.ui.tools.adapters

import android.animation.Animator
import android.animation.ObjectAnimator
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.utils.Utils
import es.uva.sensorphysics.R
import es.uva.sensorphysics.model.Tool
import es.uva.sensorphysics.utils.inflate
import kotlinx.android.synthetic.main.item_tool_list.view.*
import java.util.HashSet

class ToolsAdapter(private val items: List<Tool>, val listener: OnItemClickListener) : RecyclerView.Adapter<ToolsAdapter.ToolsViewHolder>() {

    private val unfoldedIndexes = HashSet<Int>()

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    private var itemListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        itemListener = listener
    }

    private fun registerToggle(position: Int) {
        if (unfoldedIndexes.contains(position))
            registerFold(position)
        else
            registerUnfold(position)
    }

    private fun registerFold(position: Int) {
        unfoldedIndexes.remove(position)
    }

    private fun registerUnfold(position: Int) {
        unfoldedIndexes.add(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToolsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tool_list, parent, false)
        return ToolsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ToolsViewHolder, position: Int) {

        holder.itemTitle.text = items[position].title
        holder.itemDescription.text = items[position].description

        holder.itemView.setOnClickListener {
            registerToggle(holder.adapterPosition)
            holder.toggleCellState(unfoldedIndexes.contains(holder.adapterPosition))
        }
    }

    inner class ToolsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemTitle: TextView = itemView.findViewById(R.id.tv_sensor_name)
        var itemDescription: TextView = itemView.findViewById(R.id.tv_sensor_name)



        fun toggleCellState(expanded: Boolean) {
            if (expanded) {

                val animation = ObjectAnimator()
                animation.duration = 400
                animation.start()
                animation.addListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(animation: Animator) {

                    }

                    override fun onAnimationEnd(animation: Animator) {

                        itemView.iv_collapsed_arrow.visibility = View.INVISIBLE
                        val fadeIn2 = ObjectAnimator.ofFloat(itemView.iv_expanded_arrow, "alpha", .3f, 1f)
                        fadeIn2.duration = 300
                        fadeIn2.start()
                        itemView.tv_sensor_description.visibility = View.VISIBLE
                        fadeIn2.addListener(object : Animator.AnimatorListener {
                            override fun onAnimationStart(animation: Animator) {

                            }

                            override fun onAnimationEnd(animation: Animator) {
                                itemListener!!.onItemClick(adapterPosition)
                            }

                            override fun onAnimationCancel(animation: Animator) {

                            }

                            override fun onAnimationRepeat(animation: Animator) {

                            }
                        })
                        val fadeIn = ObjectAnimator.ofFloat(itemView.tv_sensor_description, "alpha", .3f, 1f)
                        fadeIn.duration = 300
                        fadeIn.start()
                        itemView.iv_expanded_arrow.visibility = View.VISIBLE

                    }

                    override fun onAnimationCancel(animation: Animator) {

                    }

                    override fun onAnimationRepeat(animation: Animator) {

                    }
                })

            } else {
                val fadeIn = ObjectAnimator.ofFloat(itemView.tv_sensor_description, "alpha", .3f, 1f)
                fadeIn.duration = 300
                fadeIn.start()

                val fadeIn2 = ObjectAnimator.ofFloat(itemView.iv_expanded_arrow, "alpha", .3f, 1f)
                fadeIn2.duration = 300
                fadeIn2.start()
                fadeIn2.addListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(animation: Animator) {
                    }

                    override fun onAnimationEnd(animation: Animator) {
                        itemView.tv_sensor_description.visibility = View.INVISIBLE
                        itemView.iv_expanded_arrow.visibility = View.INVISIBLE
                        itemView.iv_collapsed_arrow.visibility = View.VISIBLE
                    }

                    override fun onAnimationCancel(animation: Animator) {
                    }

                    override fun onAnimationRepeat(animation: Animator) {
                    }
                })
            }
        }
    }

}