package com.samsung.android.sdk.look.smartclip;

import android.view.View;
import com.samsung.android.sdk.look.Slook;
import com.samsung.android.smartclip.SmartClipDataExtractionListener;
import com.samsung.android.smartclip.SmartClipMetaUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SlookSmartClip {
    private static final String TAG = "SmartClip";
    private DataExtractionListener mDataExtractionListener = null;
    private Slook mSlook = new Slook();
    private View mView = null;

    /* renamed from: com.samsung.android.sdk.look.smartclip.SlookSmartClip$1 */
    class C09121 implements SmartClipDataExtractionListener {
        C09121() {
        }

        public int onExtractSmartClipData(View view, SlookSmartClipDataElement slookSmartClipDataElement, SlookSmartClipCroppedArea slookSmartClipCroppedArea) {
            AppMethodBeat.m2504i(117213);
            int onExtractSmartClipData = SlookSmartClip.this.mDataExtractionListener.onExtractSmartClipData(view, slookSmartClipDataElement, slookSmartClipCroppedArea);
            AppMethodBeat.m2505o(117213);
            return onExtractSmartClipData;
        }
    }

    public interface DataExtractionListener {
        public static final int EXTRACTION_DEFAULT = 1;
        public static final int EXTRACTION_DISCARD = 0;

        int onExtractSmartClipData(View view, SlookSmartClipDataElement slookSmartClipDataElement, SlookSmartClipCroppedArea slookSmartClipCroppedArea);
    }

    public SlookSmartClip(View view) {
        AppMethodBeat.m2504i(117214);
        this.mView = view;
        AppMethodBeat.m2505o(117214);
    }

    public final void addMetaTag(SlookSmartClipMetaTag slookSmartClipMetaTag) {
        AppMethodBeat.m2504i(117215);
        if (isSupport(1)) {
            SmartClipMetaUtils.addMetaTag(this.mView, slookSmartClipMetaTag);
            AppMethodBeat.m2505o(117215);
            return;
        }
        AppMethodBeat.m2505o(117215);
    }

    public final void removeMetaTag(String str) {
        AppMethodBeat.m2504i(117216);
        if (isSupport(1)) {
            SmartClipMetaUtils.removeMetaTag(this.mView, str);
            AppMethodBeat.m2505o(117216);
            return;
        }
        AppMethodBeat.m2505o(117216);
    }

    public final void clearAllMetaTag() {
        AppMethodBeat.m2504i(117217);
        if (isSupport(1)) {
            SmartClipMetaUtils.clearAllMetaTag(this.mView);
            AppMethodBeat.m2505o(117217);
            return;
        }
        AppMethodBeat.m2505o(117217);
    }

    public final void setDataExtractionListener(DataExtractionListener dataExtractionListener) {
        AppMethodBeat.m2504i(117218);
        if (isSupport(1)) {
            this.mDataExtractionListener = dataExtractionListener;
            SmartClipMetaUtils.setDataExtractionListener(this.mView, new C09121());
            AppMethodBeat.m2505o(117218);
            return;
        }
        AppMethodBeat.m2505o(117218);
    }

    public final int extractDefaultSmartClipData(SlookSmartClipDataElement slookSmartClipDataElement, SlookSmartClipCroppedArea slookSmartClipCroppedArea) {
        AppMethodBeat.m2504i(117219);
        if (isSupport(1)) {
            int extractDefaultSmartClipData = SmartClipMetaUtils.extractDefaultSmartClipData(this.mView, slookSmartClipDataElement, slookSmartClipCroppedArea);
            AppMethodBeat.m2505o(117219);
            return extractDefaultSmartClipData;
        }
        AppMethodBeat.m2505o(117219);
        return 0;
    }

    private boolean isSupport(int i) {
        AppMethodBeat.m2504i(117220);
        if (this.mSlook.isFeatureEnabled(2)) {
            AppMethodBeat.m2505o(117220);
            return true;
        }
        AppMethodBeat.m2505o(117220);
        return false;
    }
}
