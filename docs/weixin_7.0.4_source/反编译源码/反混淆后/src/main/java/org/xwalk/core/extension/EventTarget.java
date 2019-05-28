package org.xwalk.core.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;

public class EventTarget extends BindingObject {
    private String TAG = "EventTarget";
    private Map<String, MessageInfo> mEvents = new HashMap();

    public EventTarget() {
        AppMethodBeat.m2504i(86095);
        this.mHandler.register("addEventListener", this);
        this.mHandler.register("removeEventListener", this);
        AppMethodBeat.m2505o(86095);
    }

    public void startEvent(String str) {
    }

    public void stopEvent(String str) {
    }

    public boolean isEventActive(String str) {
        AppMethodBeat.m2504i(86096);
        boolean containsKey = this.mEvents.containsKey(str);
        AppMethodBeat.m2505o(86096);
        return containsKey;
    }

    public void dispatchEvent(String str) {
        AppMethodBeat.m2504i(86097);
        dispatchEvent(str, null);
        AppMethodBeat.m2505o(86097);
    }

    public void dispatchEvent(String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(86098);
        try {
            if (this.mEvents.containsKey(str)) {
                MessageInfo messageInfo = (MessageInfo) this.mEvents.get(str);
                JSONArray jSONArray = new JSONArray();
                if (jSONObject != null) {
                    jSONArray.put(0, jSONObject);
                }
                messageInfo.postResult(jSONArray);
                AppMethodBeat.m2505o(86098);
                return;
            }
            Log.m81051w(this.TAG, "Attempt to dispatch to non-existing event :".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(86098);
        } catch (JSONException e) {
            Log.m81046e(this.TAG, e.toString());
            AppMethodBeat.m2505o(86098);
        }
    }

    public void onAddEventListener(MessageInfo messageInfo) {
        AppMethodBeat.m2504i(86099);
        try {
            String string = messageInfo.getArgs().getString(0);
            if (this.mEvents.containsKey(string)) {
                Log.m81051w(this.TAG, "Trying to re-add the event :".concat(String.valueOf(string)));
                AppMethodBeat.m2505o(86099);
                return;
            }
            this.mEvents.put(string, messageInfo);
            startEvent(string);
            AppMethodBeat.m2505o(86099);
        } catch (JSONException e) {
            Log.m81046e(this.TAG, e.toString());
            AppMethodBeat.m2505o(86099);
        }
    }

    public void onRemoveEventListener(MessageInfo messageInfo) {
        AppMethodBeat.m2504i(86100);
        try {
            String string = messageInfo.getArgs().getString(0);
            if (this.mEvents.containsKey(string)) {
                stopEvent(string);
                this.mEvents.remove(string);
                AppMethodBeat.m2505o(86100);
                return;
            }
            Log.m81051w(this.TAG, "Attempt to remove non-existing event :".concat(String.valueOf(string)));
            AppMethodBeat.m2505o(86100);
        } catch (JSONException e) {
            Log.m81046e(this.TAG, e.toString());
            AppMethodBeat.m2505o(86100);
        }
    }
}
