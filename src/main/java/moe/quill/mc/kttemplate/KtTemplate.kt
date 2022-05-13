package moe.quill.mc.kttemplate;

import org.bukkit.plugin.java.JavaPlugin;

class KtTemplate : JavaPlugin(){
    override fun onEnable() {
        logger.info("Hello World!")
    }
}
