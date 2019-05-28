package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class RetrieveDataManager {
    private static final ThreadLocal<RetrieveDataManager> INSTANCE = new ThreadLocal<RetrieveDataManager>() {
        /* Access modifiers changed, original: protected|final */
        public final RetrieveDataManager initialValue() {
            AppMethodBeat.i(83964);
            RetrieveDataManager retrieveDataManager = new RetrieveDataManager();
            AppMethodBeat.o(83964);
            return retrieveDataManager;
        }
    };
    private final TexSaveProcess mRGBATexSaveProcess = new RGBATexSaveProcess();
    private final TexSaveProcess mYUVTexSaveProcess = new YUVTexSaveProcess();

    public enum DATA_TYPE {
        RGBA(0),
        YUV(1);
        
        public int value;

        static {
            AppMethodBeat.o(83968);
        }

        private DATA_TYPE(int i) {
            this.value = i;
        }
    }

    public RetrieveDataManager() {
        AppMethodBeat.i(83969);
        AppMethodBeat.o(83969);
    }

    static {
        AppMethodBeat.i(83974);
        AppMethodBeat.o(83974);
    }

    public static RetrieveDataManager getInstance() {
        AppMethodBeat.i(83970);
        RetrieveDataManager retrieveDataManager = (RetrieveDataManager) INSTANCE.get();
        AppMethodBeat.o(83970);
        return retrieveDataManager;
    }

    public byte[] retrieveData(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(83971);
        TexSaveProcess createTexSaveProcess = createTexSaveProcess(i);
        byte[] retrieveData;
        if (createTexSaveProcess != null) {
            retrieveData = createTexSaveProcess.retrieveData(i2, i3, i4);
            AppMethodBeat.o(83971);
            return retrieveData;
        }
        retrieveData = new byte[0];
        AppMethodBeat.o(83971);
        return retrieveData;
    }

    private TexSaveProcess createTexSaveProcess(int i) {
        if (i == DATA_TYPE.RGBA.value) {
            return this.mRGBATexSaveProcess;
        }
        if (i == DATA_TYPE.YUV.value) {
            return this.mYUVTexSaveProcess;
        }
        return null;
    }

    public boolean isValid(int i) {
        AppMethodBeat.i(83972);
        for (DATA_TYPE data_type : DATA_TYPE.values()) {
            if (data_type.value == i) {
                AppMethodBeat.o(83972);
                return true;
            }
        }
        AppMethodBeat.o(83972);
        return false;
    }

    public void clear() {
        AppMethodBeat.i(83973);
        this.mRGBATexSaveProcess.clear();
        this.mYUVTexSaveProcess.clear();
        AppMethodBeat.o(83973);
    }
}
