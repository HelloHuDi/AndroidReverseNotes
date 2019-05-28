package com.tencent.p177mm.modelsimple;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.modelsimple.BindWordingContent */
public class BindWordingContent implements Parcelable {
    public static final Creator<BindWordingContent> CREATOR = new C18701();
    public Integer bWu = Integer.valueOf(0);
    public String content = "";
    public String title = "";

    /* renamed from: com.tencent.mm.modelsimple.BindWordingContent$1 */
    static class C18701 implements Creator<BindWordingContent> {
        C18701() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BindWordingContent[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(123424);
            BindWordingContent bindWordingContent = new BindWordingContent(parcel);
            AppMethodBeat.m2505o(123424);
            return bindWordingContent;
        }
    }

    public BindWordingContent(String str, String str2) {
        AppMethodBeat.m2504i(123425);
        this.title = str;
        this.content = str2;
        AppMethodBeat.m2505o(123425);
    }

    public BindWordingContent(Parcel parcel) {
        AppMethodBeat.m2504i(123426);
        String[] strArr = new String[2];
        parcel.readStringArray(strArr);
        this.title = strArr[0];
        this.content = strArr[1];
        this.bWu = Integer.valueOf(parcel.readInt());
        AppMethodBeat.m2505o(123426);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(123427);
        parcel.writeStringArray(new String[]{this.title, this.content});
        parcel.writeInt(this.bWu.intValue());
        AppMethodBeat.m2505o(123427);
    }

    static {
        AppMethodBeat.m2504i(123428);
        AppMethodBeat.m2505o(123428);
    }
}
