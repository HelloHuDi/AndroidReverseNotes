package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class RetrieveDataManager {
    private static final ThreadLocal<RetrieveDataManager> INSTANCE = new C311241();
    private final TexSaveProcess mRGBATexSaveProcess = new RGBATexSaveProcess();
    private final TexSaveProcess mYUVTexSaveProcess = new YUVTexSaveProcess();

    public enum DATA_TYPE {
        RGBA(0),
        YUV(1);
        
        public int value;

        static {
            AppMethodBeat.m2505o(83968);
        }

        private DATA_TYPE(int i) {
            this.value = i;
        }
    }

    /* renamed from: com.tencent.ttpic.util.RetrieveDataManager$1 */
    static class C311241 extends ThreadLocal<RetrieveDataManager> {
        C311241() {
        }

        /* Access modifiers changed, original: protected|final */
        public final RetrieveDataManager initialValue() {
            AppMethodBeat.m2504i(83964);
            RetrieveDataManager retrieveDataManager = new RetrieveDataManager();
            AppMethodBeat.m2505o(83964);
            return retrieveDataManager;
        }
    }

    public RetrieveDataManager() {
        AppMethodBeat.m2504i(83969);
        AppMethodBeat.m2505o(83969);
    }

    static {
        AppMethodBeat.m2504i(83974);
        AppMethodBeat.m2505o(83974);
    }

    public static RetrieveDataManager getInstance() {
        AppMethodBeat.m2504i(83970);
        RetrieveDataManager retrieveDataManager = (RetrieveDataManager) INSTANCE.get();
        AppMethodBeat.m2505o(83970);
        return retrieveDataManager;
    }

    public byte[] retrieveData(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(83971);
        TexSaveProcess createTexSaveProcess = createTexSaveProcess(i);
        byte[] retrieveData;
        if (createTexSaveProcess != null) {
            retrieveData = createTexSaveProcess.retrieveData(i2, i3, i4);
            AppMethodBeat.m2505o(83971);
            return retrieveData;
        }
        retrieveData = new byte[0];
        AppMethodBeat.m2505o(83971);
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
        AppMethodBeat.m2504i(83972);
        for (DATA_TYPE data_type : DATA_TYPE.values()) {
            if (data_type.value == i) {
                AppMethodBeat.m2505o(83972);
                return true;
            }
        }
        AppMethodBeat.m2505o(83972);
        return false;
    }

    public void clear() {
        AppMethodBeat.m2504i(83973);
        this.mRGBATexSaveProcess.clear();
        this.mYUVTexSaveProcess.clear();
        AppMethodBeat.m2505o(83973);
    }
}
