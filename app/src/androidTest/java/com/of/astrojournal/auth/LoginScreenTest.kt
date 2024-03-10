package com.of.astrojournal.auth

import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.hasAnyAncestor
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.hasInsertTextAtCursorAction
import androidx.compose.ui.test.hasParent
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import com.of.astrojournal.R
import com.of.astrojournal.auth.login.tooling.LoginScreenTestData
import org.junit.Rule
import org.junit.Test

class LoginScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun loginScreenTest_titleDisplayed() {
        val resources = InstrumentationRegistry.getInstrumentation().targetContext.resources

        composeTestRule.setContent {
            LoginScreenTestData()
        }

        composeTestRule
            .onNode(
                hasText(resources.getString(R.string.app_name)) and
                hasParent(
                    hasContentDescription(resources.getString(R.string.designsystem_semantic_top_bar))
                )
            )
    }

    @Test
    fun loginScreenTest_emailTextFieldEnabled() {
        val resources = InstrumentationRegistry.getInstrumentation().targetContext.resources

        composeTestRule.setContent {
            LoginScreenTestData()
        }

        composeTestRule
            .onNode(
                hasText(resources.getString(R.string.auth_login_textfield_email)) and
                        hasInsertTextAtCursorAction() and
                        hasAnyAncestor(
                            hasContentDescription(resources.getString(R.string.auth_semantic_login_screen))
                        )
            )
            .assertIsEnabled()
    }

    @Test
    fun loginScreenTest_passwordTextFieldEnabled() {
        val resources = InstrumentationRegistry.getInstrumentation().targetContext.resources

        composeTestRule.setContent {
            LoginScreenTestData()
        }

        composeTestRule
            .onNode(
                hasText(resources.getString(R.string.auth_login_textfield_password)) and
                        hasInsertTextAtCursorAction() and
                        hasAnyAncestor(
                            hasContentDescription(resources.getString(R.string.auth_semantic_login_screen))
                        )
            )
            .assertIsEnabled()
    }

    @Test
    fun loginScreenTest_showPasswordButtonEnabled() {
        val resources = InstrumentationRegistry.getInstrumentation().targetContext.resources

        composeTestRule.setContent {
            LoginScreenTestData()
        }

        composeTestRule
            .onNode(
                hasContentDescription(resources.getString(R.string.designsystem_semantic_eye_icon_button)) and
                        hasParent(
                            hasText(resources.getString(R.string.auth_login_textfield_password)) and
                            hasInsertTextAtCursorAction()
                        )
            )
            .assertIsEnabled()
    }

    @Test
    fun loginScreenTest_forgotPasswordEnabled() {
        val resources = InstrumentationRegistry.getInstrumentation().targetContext.resources

        composeTestRule.setContent {
            LoginScreenTestData()
        }

        composeTestRule
            .onNode(
                hasText(resources.getString(R.string.auth_login_button_forgot_password)) and
                hasClickAction() and
                hasAnyAncestor(
                    hasContentDescription(resources.getString(R.string.auth_semantic_login_screen))
                )
            )
            .assertIsEnabled()
    }

    @Test
    fun loginScreenTest_loginButtonEnabled() {
        val resources = InstrumentationRegistry.getInstrumentation().targetContext.resources

        composeTestRule.setContent {
            LoginScreenTestData()
        }

        composeTestRule
            .onNode(
                hasText(resources.getString(R.string.auth_login_button_login)) and
                        hasClickAction() and
                        hasAnyAncestor(
                            hasContentDescription(resources.getString(R.string.auth_semantic_login_screen))
                        )
            )
            .assertIsEnabled()
    }

    @Test
    fun loginScreenTest_registerButtonEnabled() {
        val resources = InstrumentationRegistry.getInstrumentation().targetContext.resources

        composeTestRule.setContent {
            LoginScreenTestData()
        }

        composeTestRule
            .onNode(
                hasText(resources.getString(R.string.auth_login_button_register)) and
                        hasClickAction() and
                        hasAnyAncestor(
                            hasContentDescription(resources.getString(R.string.auth_semantic_login_screen))
                        )
            )
            .assertIsEnabled()
    }

}