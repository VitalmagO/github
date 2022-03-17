package ru.skblab.mygithub.screens.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ru.skblab.mygithub.RootActivity
import ru.skblab.mygithub.databinding.FragmentListBinding
import ru.skblab.mygithub.screens.detail.DetailFragment
import ru.skblab.mygithub.screens.list.adapter.ListAdapter
import ru.skblab.mygithub.utils.Mock

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = requireActivity() as RootActivity

        with(binding.recycleView) {
            adapter = ListAdapter(Mock.getStringList()).apply {
                onClickListener = { item ->
                    DetailFragment.create(item).show(parentFragmentManager, DetailFragment.TAG)
                }
            }
            layoutManager = LinearLayoutManager(requireContext())
        }

        requireActivity().onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity.router.exit()
            }
        })
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}