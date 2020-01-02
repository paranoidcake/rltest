import java.util.ArrayList
import kotlin.reflect.KFunction

abstract class State {
    abstract val task: Task
    abstract var value: Any
    abstract val reward: Double

    fun getActions(): List<KFunction<State>> {
        return task.getActions(this)
    }

    override fun equals(other: Any?): Boolean {
        return if(other is State) {
            value == other.value && task === other.task
        } else {
            false
        }
    }

    override fun hashCode(): Int {
        var result = task.hashCode()
        result = 31 * result + value.hashCode()
        return result
    }
}
