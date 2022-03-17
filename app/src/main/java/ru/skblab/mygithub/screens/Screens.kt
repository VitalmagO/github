package ru.skblab.mygithub.screens

import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.Creator
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.skblab.mygithub.flows.bottom.BottomFlowFragment
import ru.skblab.mygithub.flows.search.SearchFlowFragment
import ru.skblab.mygithub.flows.list.ListFlowFragment
import ru.skblab.mygithub.screens.tabs.SearchFragment
import ru.skblab.mygithub.screens.list.ListFragment
import ru.skblab.mygithub.base.FlowRouter

object Screens {

//    object Search :
//        FragmentScreen(SearchFragment::class.java.name,
//            Creator { SearchFragment() })

    object List :
        FragmentScreen(ListFragment::class.java.name,
            Creator { ListFragment() })

    class SearchFlow(
        private val flowRouter: FlowRouter,
        var navigationHolder: NavigatorHolder
    ) : FragmentScreen(
        SearchFlowFragment::class.java.name,
        Creator { SearchFlowFragment(flowRouter, navigationHolder) })

    class ListFlow(
        private val flowRouter: FlowRouter,
        var navigationHolder: NavigatorHolder
    ) : FragmentScreen(
        ListFlowFragment::class.java.name,
        Creator { ListFlowFragment(flowRouter, navigationHolder) })

    class BottomFlow(
        private val flowRouter: FlowRouter,
        private val navigationHolder: NavigatorHolder
    ) : FragmentScreen(
        BottomFlowFragment::class.java.name,
        Creator { BottomFlowFragment(flowRouter, navigationHolder) })
}