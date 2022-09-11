package com.patika.week3appnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.patika.week3appnavigation.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var fragmentLoginBinding: FragmentLoginBinding

    val usrName = arrayOf("Kurt", "Dam", "Belushi", "Cohen")
    val usrPassword = arrayOf("123", "456", "789", "100")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentLoginBinding = FragmentLoginBinding.inflate(layoutInflater)
        val view = fragmentLoginBinding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentLoginBinding.apply {
            loginButton.setOnClickListener {
                login(view)
            }

        }
    }

    fun <T> isPresent(arr: Array<T>, target: T): Boolean {
        return arr.contains(target)
    }

    fun login(view: View) {
        val enteredName = fragmentLoginBinding.editTextUserName.text.toString()
        val password = fragmentLoginBinding.editTextPassword.text.toString()

        if (enteredName.isNotEmpty() && password.isNotEmpty()) {
            if (isPresent(usrName, enteredName) && isPresent(usrPassword, password)) {
                Toast.makeText(context, "Welcome: ${enteredName}", Toast.LENGTH_LONG).show()

                findNavController().navigate(R.id.action_login_graph_to_main_graph)

            } else {
                Toast.makeText(context, "Invalid Password or User Name", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(context, "Please enter Username and Password", Toast.LENGTH_SHORT).show()
        }
    }


}