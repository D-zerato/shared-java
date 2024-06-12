/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.
 * @since 2014. 6. 10.
 */

package dz.shared.util.json;

import java.io.Serializable;

public interface JsonSerializable extends Serializable {
    //
    default String toJson() {
        //
        return JsonUtils.toJson(this);
    }
}
