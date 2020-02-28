package com.github.djaler.evilbot.handlers

import com.github.djaler.evilbot.components.TelegramClient
import com.github.djaler.evilbot.service.UserService
import com.github.insanusmokrassar.TelegramBotAPI.types.User
import com.github.insanusmokrassar.TelegramBotAPI.types.message.CommonMessageImpl
import org.springframework.stereotype.Component

@Component
class SwitchGenderHandler(
    private val telegramClient: TelegramClient,
    private val userService: UserService,
    botInfo: User
) : CommandHandler(botInfo, command = arrayOf("switch_gender")) {
    override suspend fun handleCommand(message: CommonMessageImpl<*>, args: String?) {
        val (userEntity, _) = userService.getOrCreateUserFrom(message.user)

        userService.switchGender(userEntity)

        val newGender = if (userEntity.male) "девочка" else "мальчик"
        telegramClient.replyTextTo(message, "Хорошо, теперь ты $newGender")
    }
}