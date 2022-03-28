package com.example.hbyssystemmanagement.View

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.hbyssystemmanagement.Common.Common
import com.example.hbyssystemmanagement.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.rey.material.widget.CheckBox
import io.paperdb.Paper

class SignInActivity : AppCompatActivity(), View.OnClickListener {


    lateinit var mDatabase : DatabaseReference
    private var user = FirebaseAuth.getInstance().currentUser
    lateinit var forgotButton:TextView
    lateinit var edtEmail:EditText
    lateinit var edtPassword:EditText
    lateinit var btn_email_create_account:Button
    lateinit var btn_email_sign_in:Button
    lateinit var btn_sign_out:Button
    lateinit var btn_verify_email:Button
    lateinit var btn_forgot_password:Button
    lateinit var email_password_buttons:LinearLayout
    lateinit var email_password_fields:LinearLayout
    lateinit var layout_signed_in_buttons:LinearLayout
    lateinit var layout_forgot_password:LinearLayout
    private val RC_SIGN_IN = 234
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var mAuth: FirebaseAuth
    private val TAG = "FirebaseEmailPassword"
    lateinit var rememberMe: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)


        edtEmail=findViewById(R.id.edtEmail)
        edtPassword=findViewById(R.id.edtPassword)
        email_password_buttons=findViewById(R.id.email_password_buttons)
        email_password_fields=findViewById(R.id.email_password_fields)
        layout_signed_in_buttons=findViewById(R.id.layout_signed_in_buttons)
        layout_forgot_password=findViewById(R.id.layout_forgot_password)
        btn_email_create_account=findViewById(R.id.btn_email_create_account)
        btn_forgot_password=findViewById(R.id.btn_forgot_password)
        btn_email_sign_in=findViewById(R.id.btn_email_sign_in)
        rememberMe=findViewById(R.id.RememberCheck)

        /*if(!common.connectivityInternet(this)){

        }else{
            Toast.makeText(this@SignInActivity, "Connect Error", Toast.LENGTH_LONG)
                .show()
        }*/
        btn_email_sign_in.setOnClickListener(this)
        btn_forgot_password.setOnClickListener(this)
        btn_email_create_account.setOnClickListener(this)

//        var uid = user!!.uid

        mDatabase = FirebaseDatabase.getInstance().getReference("User")

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)
        mAuth = FirebaseAuth.getInstance()
        Paper.init(this)


        /*val user: String = Paper.book().read("User_Key".toString())
        val pass: String = Paper.book().read("Pwd_Key".toString())
        if (user != null && pass != null) {
            if (!user.isEmpty() && !pass.isEmpty()) {
                signIn(user, pass)
            }
        }*/


    }

    override fun onStart() {
        super.onStart()

        val currentUser = mAuth!!.currentUser

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e)
            }
        }
    }
    // [END onactivityresult]

    // [START auth_with_google]
    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information


                    startActivity(Intent(applicationContext,HomeActivity::class.java))
                    Log.d(TAG, "signInWithCredential:success")
                    val user = mAuth.currentUser

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.exception)

                }
            }
    }
    // [END auth_with_google]

    // [START signin]
    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onClick(view: View?) {
        val i = view!!.id

        if (i == R.id.btn_email_create_account) {
            startActivity(Intent(applicationContext, SignUpActivity::class.java))
        } else if (i == R.id.btn_email_sign_in) {
            signIn(edtEmail.text.toString(), edtPassword.text.toString())
        } else if (i == R.id.btn_forgot_password) {
            startActivity(Intent(applicationContext, ResetPasswordActivity::class.java))
        }
    }



    private fun signIn(email: String, password: String) {


        Log.e(TAG, "signIn:" + email)
        if (!validateForm(email, password)) {
            return
        }
        /*var mDialog= ProgressDialog(this@SignInActivity)
        mDialog.setMessage("Please waiting..")
        mDialog.show()*/
        if(Common.connectivityInternet(applicationContext)) {
            if (rememberMe.isChecked()) {
                Paper.book().write<String>("User_Key", email)
                Paper.book().write<String>("Pwd_Key", password)
            }
            mAuth!!.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {

                        Log.e(TAG, "signIn: Success!")
                        startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
                        finish()

                    } else {
                        Log.e(TAG, "signIn: Fail!", task.exception)
                        Toast.makeText(this, "Authentication failed!", Toast.LENGTH_SHORT).show()
                        validateForm(email,password)

                    }

                }
        }else{
            Toast.makeText(this, "Please Check Your Connection!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun signOut() {
        mAuth!!.signOut()

    }




    private fun validateForm(email: String, password: String): Boolean {

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(applicationContext, "Enter email address!", Toast.LENGTH_SHORT).show()
            return false
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(applicationContext, "Enter password!", Toast.LENGTH_SHORT).show()
            return false
        }

        if (password.length < 6) {
            Toast.makeText(applicationContext, "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    /*private fun updateUI(user: FirebaseUser?) {

        if (user != null) {


            email_password_buttons.visibility = View.GONE
            email_password_fields.visibility = View.GONE
            layout_signed_in_buttons.visibility = View.VISIBLE


            layout_forgot_password.visibility = View.GONE
        } else {


            email_password_buttons.visibility = View.VISIBLE
            email_password_fields.visibility = View.VISIBLE
            layout_signed_in_buttons.visibility = View.GONE

            layout_forgot_password.visibility = View.VISIBLE
        }
    }*/
    /*private fun login () {

        val emailTxt = findViewById<View>(R.id.editEmail) as EditText
        var email = emailTxt.text.toString()
        val passwordTxt = findViewById<View>(R.id.editPassword) as EditText
        val rememberMe = findViewById<View>(R.id.RememberCheck) as CheckBox
        var password = passwordTxt.text.toString()

        if (rememberMe.isChecked()) {
            Paper.book().write(Common.User_Key, email)
            Paper.book().write(Common.Pwd_Key, password)
        }
        val builder = AlertDialog.Builder(this@SignInActivity)
        builder.setMessage("Please waiting...")
        val alert = builder.create()
        alert.setIcon(R.drawable.waiting)
        alert.show()


        if (!email.isEmpty() && !password.isEmpty()) {
            this.mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener ( this, OnCompleteListener<AuthResult> { task ->
                if (task.isSuccessful) {
                    alert.dismiss()
                    startActivity(Intent(this, MainActivity::class.java))
                    Toast.makeText(this, "Successfully Logged in ", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Error Logging in ", Toast.LENGTH_SHORT).show()
                }
            })

        }else {
            Toast.makeText(this, "Please fill up the Credentials :|", Toast.LENGTH_SHORT).show()
        }
    }
    private fun showUpdateDialog() {
        val alertDialog = AlertDialog.Builder(this@SignInActivity)
        alertDialog.setTitle("Secure code")
        alertDialog.setMessage("Please fill full information")
        val inflater = layoutInflater
        val add_menu_layout: View = inflater.inflate(R.layout.secure_code_activity, null)
        val forgotCode = add_menu_layout.findViewById<TextView>(R.id.againPass)
        val ok = add_menu_layout.findViewById<Button>(R.id.okButton)
        val sendEmail = add_menu_layout.findViewById<TextView>(R.id.passForgot)
        alertDialog.setView(add_menu_layout)
        alertDialog.setPositiveButton(
            "Yes"
        ) { dialogInterface, i ->
            dialogInterface.dismiss()
            mDatabase.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val user: User? = snapshot.child(uid).getValue(User::class.java)
                    if (user!!.getSecureCode().equals(forgotCode.getText().toString())) {
                        val intent = Intent(this@SignInActivity, ResetPasswordActivity::class.java)
                        intent.putExtra("uid", uid)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@SignInActivity, "Error Secure Code", Toast.LENGTH_LONG)
                            .show()
                    }
                }

                override fun onCancelled(error: DatabaseError) {}
            })
        }
        alertDialog.setNegativeButton(
            "No"
        ) { dialogInterface, i -> dialogInterface.dismiss() }
        alertDialog.show()
    }*/

    // Initialize Firebase Auth





}