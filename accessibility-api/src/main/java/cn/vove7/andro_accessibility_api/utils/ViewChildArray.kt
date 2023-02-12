package cn.vove7.andro_accessibility_api.utils

import cn.vove7.andro_accessibility_api.viewnode.ViewNode

/**
 * # ViewChildArray
 *
 * @author Libra
 * @date 2023/2/11
 */
class ViewChildList constructor(val node: ViewNode?) : ArrayList<ViewNode?>(node?.childCount ?: 0) {

    constructor() : this(null)

    init {
        if (node != null) {
            addAll(
                (0 until node.childCount).map { i ->
                    node.node.getChild(i)?.let { ViewNode(it) }
                }
            )
        }
    }

    override fun get(index: Int): ViewNode {
        return super.get(index)
            ?: throw NullPointerException("child is null at $index of ${node ?: "root"}")
    }

    override fun set(index: Int, element: ViewNode?): ViewNode? {
        throw UnsupportedOperationException()
    }
}