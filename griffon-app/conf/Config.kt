import griffon.util.AbstractMapResourceBundle

class Config : AbstractMapResourceBundle() {
    override fun initialize(entries: MutableMap<String, Any>) {
        entries.put("application", hashMapOf(
                "title" to "app",
                "startupGroups" to listOf("main"),
                "autoshutdown" to true
        ))
        entries.put("mvcGroups", hashMapOf(
                "main" to hashMapOf(
                        "model" to "gui.MainModel",
                        "view" to "gui.MainView",
                        "controller" to "gui.MainController"
                )
        ))
    }
}