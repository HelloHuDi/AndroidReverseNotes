package com.tencent.ttpic.cache;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gameplaysdk.GamePlaySDK;
import java.util.List;

public class LoadImageTask3D extends AsyncTask<Void, Integer, Boolean> {
    private String dataPath;
    private List<String> resourceList;

    public LoadImageTask3D(String str, List<String> list) {
        this.dataPath = str;
        this.resourceList = list;
    }

    /* Access modifiers changed, original: protected|varargs */
    public Boolean doInBackground(Void... voidArr) {
        AppMethodBeat.m2504i(81801);
        if (this.resourceList != null) {
            for (String loadItemImage : this.resourceList) {
                GamePlaySDK.getInstance().loadItemImage(this.dataPath, loadItemImage);
            }
        }
        Boolean bool = Boolean.TRUE;
        AppMethodBeat.m2505o(81801);
        return bool;
    }

    /* Access modifiers changed, original: protected */
    public void onCancelled(Boolean bool) {
        AppMethodBeat.m2504i(81802);
        super.onCancelled(bool);
        AppMethodBeat.m2505o(81802);
    }
}
