package ru.skblab.mygithub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import ru.skblab.mygithub.base.FlowRouter
import ru.skblab.mygithub.databinding.ActivityRootBinding
import ru.skblab.mygithub.screens.Screens
import ru.skblab.mygithub.utils.NavigationInterface

class RootActivity : AppCompatActivity(), NavigationInterface {

    private var _binding: ActivityRootBinding? = null
    private val binding get() = _binding!!

    lateinit var router: Router

    var cicerone: Cicerone<Router> = Cicerone.create()

    private val navigator = object : AppNavigator(
        this,
        R.id.container,
        supportFragmentManager
    ) {

        override fun setupFragmentTransaction(
            fragmentTransaction: FragmentTransaction,
            currentFragment: Fragment?,
            nextFragment: Fragment?
        ) {
            fragmentTransaction.setReorderingAllowed(true)
            if (currentFragment != null) {
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            }
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        cicerone.getNavigatorHolder().setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        cicerone.getNavigatorHolder().removeNavigator()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityRootBinding.inflate(layoutInflater)

        setContentView(binding.root)

        router = cicerone.router

        toBottomFlow()
    }

    override fun toBottomFlow() = router.newRootScreen(
        Screens.BottomFlow(
            FlowRouter(cicerone.router),
            cicerone.getNavigatorHolder()
        )
    )
}