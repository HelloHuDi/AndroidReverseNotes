package com.tencent.ttpic.cache;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gameplaysdk.GamePlaySDK;
import java.util.List;

public class Load3DTextureTask extends AsyncTask<Void, Integer, Boolean> {
    private String dataPath;
    private List<String> resourceList;

    public Load3DTextureTask(String str, List<String> list) {
        this.dataPath = str;
        this.resourceList = list;
    }

    /* Access modifiers changed, original: protected|varargs */
    public Boolean doInBackground(Void... voidArr) {
        AppMethodBeat.i(81776);
        if (this.resourceList != null) {
            for (String loadItemImage : this.resourceList) {
                GamePlaySDK.getInstance().loadItemImage(this.dataPath, loadItemImage, true);
            }
        }
        Boolean bool = Boolean.TRUE;
        AppMethodBeat.o(81776);
        return bool;
    }

    /* Access modifiers changed, original: protected */
    public void onCancelled(Boolean bool) {
        AppMethodBeat.i(81777);
        super.onCancelled(bool);
        AppMethodBeat.o(81777);
    }
}
