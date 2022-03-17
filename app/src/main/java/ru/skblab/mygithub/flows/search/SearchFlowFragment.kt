package ru.skblab.mygithub.flows.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.terrakok.cicerone.NavigatorHolder
import ru.skblab.mygithub.screens.Screens
import ru.skblab.mygithub.base.FlowFragment
import ru.skblab.mygithub.base.FlowRouter
import ru.skblab.mygithub.databinding.FragmentContainerBinding
import ru.skblab.mygithub.utils.setLaunchScreen

class SearchFlowFragment(
    override var flowRouter: FlowRouter,
    override var navigationHolder: NavigatorHolder
) : FlowFragment() {

    private var _binding: FragmentContainerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContainerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        if (childFragmentManager.fragments.isEmpty()) {
//            navigator.setLaunchScreen(Screens.Search)
//        }
    }
}