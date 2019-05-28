package org.xwalk.core.extension;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;

public class MessageInfo {
    private String TAG = "MessageInfo";
    private JSONArray mArgs;
    private ByteBuffer mBinaryArgs;
    private String mCallbackId;
    private String mCmd;
    private XWalkExternalExtension mExtension;
    private int mInstanceId;
    private String mJsName;
    private String mObjectId;

    private int AlignedWith4Bytes(int i) {
        return (4 - (i % 4)) + i;
    }

    public MessageInfo(MessageInfo messageInfo) {
        this.mExtension = messageInfo.mExtension;
        this.mInstanceId = messageInfo.mInstanceId;
        this.mJsName = messageInfo.mJsName;
        this.mCallbackId = messageInfo.mCallbackId;
        this.mObjectId = messageInfo.mObjectId;
        this.mArgs = messageInfo.mArgs;
        this.mCmd = messageInfo.mCmd;
    }

    public MessageInfo(XWalkExternalExtension xWalkExternalExtension, int i, String str) {
        AppMethodBeat.i(86132);
        this.mExtension = xWalkExternalExtension;
        this.mInstanceId = i;
        if (str.trim().charAt(0) == '[') {
            try {
                this.mArgs = new JSONArray(str);
                this.mCmd = "invokeNative";
                this.mJsName = this.mArgs.getString(0);
                this.mCallbackId = this.mArgs.getString(1);
                this.mObjectId = this.mArgs.getString(2);
                if (VERSION.SDK_INT >= 19) {
                    this.mArgs.remove(0);
                    this.mArgs.remove(0);
                    this.mArgs.remove(0);
                }
                AppMethodBeat.o(86132);
                return;
            } catch (JSONException e) {
                Log.e(this.TAG, e.toString());
                AppMethodBeat.o(86132);
                return;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("cmd");
            int i2 = jSONObject.getInt("objectId");
            this.mCmd = string;
            this.mObjectId = Integer.toString(i2);
            this.mCallbackId = Integer.toString(0);
            string = jSONObject.getString("type");
            this.mArgs = new JSONArray();
            if (string.equals(JsStubGenerator.MSG_TO_EXTENSION)) {
                this.mArgs = jSONObject.getJSONArray("args");
                this.mJsName = jSONObject.getString("name");
                if (this.mCmd.equals("newInstance")) {
                    this.mObjectId = this.mArgs.getString(0);
                    this.mArgs = this.mArgs.getJSONArray(1);
                    AppMethodBeat.o(86132);
                    return;
                }
            }
            this.mJsName = string;
            this.mArgs.put(0, jSONObject.getString("name"));
            this.mArgs.put(1, jSONObject.getJSONArray("args"));
            AppMethodBeat.o(86132);
        } catch (JSONException e2) {
            Log.e(this.TAG, e2.toString());
            AppMethodBeat.o(86132);
        }
    }

    public MessageInfo(XWalkExternalExtension xWalkExternalExtension, int i, byte[] bArr) {
        AppMethodBeat.i(86133);
        this.mExtension = xWalkExternalExtension;
        this.mInstanceId = i;
        this.mCmd = "invokeNative";
        try {
            this.mArgs = null;
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            if (wrap.order() != ByteOrder.LITTLE_ENDIAN) {
                wrap.order(ByteOrder.LITTLE_ENDIAN);
            }
            int position = wrap.position();
            int i2 = wrap.getInt(position);
            int AlignedWith4Bytes = AlignedWith4Bytes(i2);
            position += 4;
            this.mJsName = new String(bArr, position, i2);
            position += AlignedWith4Bytes;
            this.mCallbackId = Integer.toString(wrap.getInt(position));
            position += 4;
            int i3 = wrap.getInt(position);
            i2 = AlignedWith4Bytes(i3);
            position += 4;
            this.mObjectId = new String(bArr, position, i3);
            i3 = position + i2;
            this.mBinaryArgs = ByteBuffer.wrap(bArr, i3, bArr.length - i3);
            AppMethodBeat.o(86133);
        } catch (IndexOutOfBoundsException e) {
            Log.e(this.TAG, e.toString());
            AppMethodBeat.o(86133);
        } catch (NullPointerException e2) {
            Log.e(this.TAG, e2.toString());
            AppMethodBeat.o(86133);
        }
    }

    public String getJsName() {
        return this.mJsName;
    }

    public void setJsName(String str) {
        this.mJsName = str;
    }

    public JSONArray getArgs() {
        return this.mArgs;
    }

    public void setArgs(JSONArray jSONArray) {
        this.mArgs = jSONArray;
    }

    public ByteBuffer getBinaryArgs() {
        return this.mBinaryArgs;
    }

    public void setBinaryArgs(ByteBuffer byteBuffer) {
        this.mBinaryArgs = byteBuffer;
    }

    public String getObjectId() {
        return this.mObjectId;
    }

    public void setObjectId(String str) {
        this.mObjectId = str;
    }

    public String getCallbackId() {
        return this.mCallbackId;
    }

    public void setCallbackId(String str) {
        this.mCallbackId = str;
    }

    public String getCmd() {
        return this.mCmd;
    }

    public void postResult(JSONArray jSONArray) {
        AppMethodBeat.i(86134);
        try {
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(0, this.mCallbackId);
            for (int i = 0; i < jSONArray.length(); i++) {
                jSONArray2.put(i + 1, jSONArray.get(i));
            }
            Log.w(this.TAG, "postResult: " + jSONArray2.toString());
            this.mExtension.postMessage(this.mInstanceId, jSONArray2.toString());
            AppMethodBeat.o(86134);
        } catch (JSONException e) {
            Log.e(this.TAG, e.toString());
            AppMethodBeat.o(86134);
        }
    }

    public XWalkExternalExtension getExtension() {
        return this.mExtension;
    }

    public int getInstanceId() {
        return this.mInstanceId;
    }

    public ExtensionInstanceHelper getInstanceHelper() {
        AppMethodBeat.i(86135);
        ExtensionInstanceHelper instanceHelper = this.mExtension.getInstanceHelper(this.mInstanceId);
        AppMethodBeat.o(86135);
        return instanceHelper;
    }

    public void postResult(byte[] bArr) {
        AppMethodBeat.i(86136);
        this.mExtension.postBinaryMessage(this.mInstanceId, bArr);
        AppMethodBeat.o(86136);
    }
}
