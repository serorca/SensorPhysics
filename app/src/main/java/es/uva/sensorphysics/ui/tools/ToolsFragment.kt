package es.uva.sensorphysics.ui.tools

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import es.uva.sensorphysics.R
import es.uva.sensorphysics.model.Tool
import es.uva.sensorphysics.model.ToolsList
import es.uva.sensorphysics.ui.tools.adapters.ToolsAdapter
import kotlinx.android.synthetic.main.fragment_tools.*

class ToolsFragment: Fragment(), ToolsAdapter.OnItemClickListener {

    private lateinit var adapter: ToolsAdapter
    private lateinit var presenter: ToolsFragmentPresenter
    private lateinit var toolList: List<Tool>

    companion object {
        fun newInstance(pinCode: String, updated: Boolean): ToolsFragment {
            return ToolsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tools, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    override fun onItemClick(position: Int) {
        presenter.clickOnRow(position)
    }

    fun initUI() {
        rv_tools.layoutManager = LinearLayoutManager(context)
        rv_tools.adapter = ToolsAdapter(ToolsList.getToolList(), this)
    }



}