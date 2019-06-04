package es.uva.sensorphysics.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import es.uva.sensorphysics.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        card_view_tools.setOnClickListener {
            val action= MainFragmentDirections.actionMainFragmentToToolsFragmentDestination()
            findNavController().navigate(action)
        }

        card_view_projects.setOnClickListener {
            val action= MainFragmentDirections.actionMainFragmentDestinationToProjects()
            findNavController().navigate(action)
        }
    }
}