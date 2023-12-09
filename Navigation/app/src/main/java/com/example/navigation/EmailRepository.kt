package com.example.navigation

class EmailRepository {
    private val emailList: MutableList<EmailDataModel> = mutableListOf()

    init {
        emailList.addAll(
            listOf(
                EmailDataModel("SDU University", "This email is about...", "Lessons Schedule", "25 Oct", R.drawable.logo_sdu),
                EmailDataModel("LeetCode", "This email is about...", "Daily Challenges", "24 Oct", R.drawable.no_profile),
                EmailDataModel("Google", "This email is about...", "Account Verification", "14 Sep", R.drawable.google_logo),
                EmailDataModel("Microsoft", "This email is about...", "Lessons Schedule", "02 Feb", R.drawable.microsoft_logo),
                EmailDataModel("GitHub", "This email is about...", "Security Advisory", "20 Dec", R.drawable.github_logo),
                EmailDataModel("SDU Library", "This email is about...", "Lessons Schedule", "11 Jul", R.drawable.sdu_library),
                EmailDataModel("Pinterest", "This email is about...", "New Boards", "08 Mar", R.drawable.pinterest_logo),
                EmailDataModel("SDU Library", "This email is about...", "Lessons Schedule", "19 Jun", R.drawable.sdu_library),
                EmailDataModel("Figma ", "This email is about...", "Lessons Schedule", "31 Jan", R.drawable.no_profile),
                EmailDataModel("Amazon", "This email is about...", "Lessons Schedule", "26 Nov", R.drawable.amazon_logo),
                EmailDataModel("Amazon AWS", "This email is about...", "Lessons Schedule", "23 Nov", R.drawable.no_profile),
                EmailDataModel("SDU University", "This email is about...", "Lessons Schedule", "25 Dec", R.drawable.logo_sdu),
            )
        )
    }

    fun getEmails(): List<EmailDataModel> {
        return emailList
    }

    fun addEmail(email: EmailDataModel) {
        emailList.add(email)
    }
}
