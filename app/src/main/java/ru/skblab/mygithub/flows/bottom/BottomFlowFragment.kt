package ru.skblab.mygithub.flows.bottom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import ru.skblab.mygithub.R
import ru.skblab.mygithub.RootActivity
import ru.skblab.mygithub.base.FlowFragment
import ru.skblab.mygithub.base.FlowRouter
import ru.skblab.mygithub.databinding.FragmentBottomFlowBinding
import ru.skblab.mygithub.screens.Screens
import ru.skblab.mygithub.utils.setLaunchScreen

class BottomFlowFragment(
    override var flowRouter: FlowRouter,
    override var navigationHolder: NavigatorHolder
) : FlowFragment() {

    private var _binding: FragmentBottomFlowBinding? = null
    private val binding get() = _binding!!

    override val navigator: Navigator
        get() = object : AppNavigator(
            requireActivity(),
            R.id.bottom_container,
            childFragmentManager
        ) {

            override fun setupFragmentTransaction(
                fragmentTransaction: FragmentTransaction,
                currentFragment: Fragment?,
                nextFragment: Fragment?
            ) {
                fragmentTransaction.setReorderingAllowed(true)
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBottomFlowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = requireActivity() as RootActivity

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_search -> navigator.setLaunchScreen(
                    Screens.ListFlow(
                        FlowRouter(activity.router),
                        navigationHolder
                    )
                )
                R.id.navigation_favorite -> navigator.setLaunchScreen(
                    Screens.ListFlow(
                        FlowRouter(activity.router),
                        navigationHolder
                    )
                )
            }
            true
        }

        binding.bottomNavigationView.selectedItemId = R.id.navigation_search
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}