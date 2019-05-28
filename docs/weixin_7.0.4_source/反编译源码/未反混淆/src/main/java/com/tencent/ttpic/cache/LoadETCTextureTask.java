package com.tencent.ttpic.cache;

import android.opengl.ETC1Util.ETC1Texture;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.etc.ETC1File;
import com.tencent.ttpic.util.ZipPkmReader;
import java.io.File;
import java.util.Map;

public class LoadETCTextureTask extends AsyncTask<Void, Integer, Boolean> {
    private Map<String, ETC1Texture> cache;
    private String dataPath;
    private final int frames;
    private final String id;
    private final String materialId;

    public LoadETCTextureTask(Map<String, ETC1Texture> map, String str, int i, String str2, String str3) {
        this.cache = map;
        this.dataPath = str2;
        this.materialId = str3;
        this.id = str;
        this.frames = i;
    }

    /* Access modifiers changed, original: protected|varargs */
    public Boolean doInBackground(Void... voidArr) {
        AppMethodBeat.i(81784);
        Boolean bool;
        if (this.cache == null) {
            bool = Boolean.FALSE;
            AppMethodBeat.o(81784);
            return bool;
        }
        ZipPkmReader zipPkmReader = new ZipPkmReader(this.dataPath);
        zipPkmReader.open();
        while (true) {
            ETC1File nextEntry = zipPkmReader.getNextEntry();
            if (nextEntry == null) {
                zipPkmReader.close();
                fillCache(this.frames, ".pkm");
                fillCache(this.frames, "_alpha.pkm");
                bool = Boolean.TRUE;
                AppMethodBeat.o(81784);
                return bool;
            } else if (isCancelled()) {
                bool = Boolean.FALSE;
                AppMethodBeat.o(81784);
                return bool;
            } else {
                this.cache.put(this.materialId + File.separator + nextEntry.getName(), nextEntry.getTexutre());
            }
        }
    }

    private void fillCache(int i, String str) {
        AppMethodBeat.i(81785);
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = this.materialId + File.separator + (this.id + "_" + String.format("%0" + LoadETCItemManager.FORMAT_COUNT + "d", new Object[]{Integer.valueOf(i2)}) + str);
            if (!this.cache.containsKey(obj)) {
                int i3 = i2;
                while (!this.cache.containsKey(obj) && i3 > 0) {
                    i3--;
                    obj = this.materialId + File.separator + (this.id + "_" + String.format("%0" + LoadETCItemManager.FORMAT_COUNT + "d", new Object[]{Integer.valueOf(i3)}) + str);
                }
                if (this.cache.containsKey(obj)) {
                    this.cache.put(this.materialId + File.separator + (this.id + "_" + String.format("%0" + LoadETCItemManager.FORMAT_COUNT + "d", new Object[]{Integer.valueOf(i2)}) + str), this.cache.get(obj));
                }
            }
        }
        AppMethodBeat.o(81785);
    }
}
