package com.tencent.p177mm.plugin.story.model.audio;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.plugin.story.model.C29309l;
import com.tencent.p177mm.plugin.story.p536ui.view.editor.item.C43665d;
import com.tencent.p177mm.protocal.protobuf.bql;
import com.tencent.p177mm.protocal.protobuf.bqm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.LinkedList;
import p000a.C0220l;
import p000a.p001a.C7987l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 @2\u00020\u0001:\u0001@B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010;\u001a\u00020\u001eH\u0016J\r\u00109\u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u0010<J\u0018\u0010=\u001a\u00020>2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u001eH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R.\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\t\"\u0004\b%\u0010\u000bR\u001a\u0010&\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001a\u0010)\u001a\u00020*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R*\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0016j\b\u0012\u0004\u0012\u00020\u0007`\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001a\"\u0004\b1\u0010\u001cR\u001a\u00102\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\t\"\u0004\b4\u0010\u000bR\u001a\u00105\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010 \"\u0004\b7\u0010\"R\u001a\u00108\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010 \"\u0004\b:\u0010\"¨\u0006A"}, dWq = {"Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "cachePath", "", "getCachePath", "()Ljava/lang/String;", "setCachePath", "(Ljava/lang/String;)V", "cached", "", "getCached", "()Z", "setCached", "(Z)V", "failed", "getFailed", "setFailed", "lyricsList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/MusicLrcBean;", "Lkotlin/collections/ArrayList;", "getLyricsList", "()Ljava/util/ArrayList;", "setLyricsList", "(Ljava/util/ArrayList;)V", "musicId", "", "getMusicId", "()I", "setMusicId", "(I)V", "musicUrl", "getMusicUrl", "setMusicUrl", "position", "getPosition", "setPosition", "request_id", "", "getRequest_id", "()J", "setRequest_id", "(J)V", "singers", "getSingers", "setSingers", "songName", "getSongName", "setSongName", "source", "getSource", "setSource", "type", "getType", "setType", "describeContents", "()Ljava/lang/Integer;", "writeToParcel", "", "flags", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.audio.AudioCacheInfo */
public final class AudioCacheInfo implements Parcelable {
    public static final Creator<AudioCacheInfo> CREATOR = new C4124b();
    private static final String TAG = TAG;
    private static final int rUc = 1;
    private static final int rUd = 2;
    private static final int rUe = 3;
    private static final int rUf = 4;
    private static final int rUg = 5;
    private static final int rUh = 0;
    private static final int rUi = 1;
    public static final C4123a rUj = new C4123a();
    public boolean aIM;
    public String cachePath;
    public int cvd;
    public String musicUrl;
    public int position;
    public int rTW;
    public ArrayList<C43665d> rTX;
    public ArrayList<String> rTY;
    public boolean rTZ;
    public String rUa;
    public long rUb;
    public int type;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0007H\u0007J\u0006\u0010\u001e\u001a\u00020\u0005J\u0006\u0010\u001f\u001a\u00020\u0005J\u0006\u0010 \u001a\u00020\u0005R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\rXD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0014\u0010\u0012\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\tR\u0014\u0010\u0016\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\tR\u0014\u0010\u0018\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\t¨\u0006!"}, dWq = {"Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "SOURCE_TYPE_NORMAL", "", "getSOURCE_TYPE_NORMAL", "()I", "SOURCE_TYPE_SEARCH", "getSOURCE_TYPE_SEARCH", "TAG", "", "getTAG", "()Ljava/lang/String;", "VIEW_TYPE_LOADING", "getVIEW_TYPE_LOADING", "VIEW_TYPE_NORMAL", "getVIEW_TYPE_NORMAL", "VIEW_TYPE_SEARCH_ENTRANCE", "getVIEW_TYPE_SEARCH_ENTRANCE", "VIEW_TYPE_SEARCH_LOADING", "getVIEW_TYPE_SEARCH_LOADING", "VIEW_TYPE_SEARCH_RESULT", "getVIEW_TYPE_SEARCH_RESULT", "createFromMusicInfo", "info", "Lcom/tencent/mm/protocal/protobuf/RecommendedMusicInfo;", "type", "createLoadingInfo", "createSearchEntranceInfo", "createSearchLoadingInfo", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.audio.AudioCacheInfo$a */
    public static final class C4123a {
        private C4123a() {
        }

        public /* synthetic */ C4123a(byte b) {
            this();
        }

        /* renamed from: a */
        public static AudioCacheInfo m6449a(bql bql, int i) {
            boolean z;
            AppMethodBeat.m2504i(109172);
            C25052j.m39376p(bql, "info");
            AudioCacheInfo audioCacheInfo = new AudioCacheInfo();
            audioCacheInfo.rTW = bql.wSJ;
            audioCacheInfo.musicUrl = bql.wSP;
            ArrayList arrayList = new ArrayList();
            LinkedList linkedList = bql.wST;
            C25052j.m39375o(linkedList, "info.lyrics");
            int i2 = 0;
            for (Object next : linkedList) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    C7987l.dWs();
                }
                bqm bqm = (bqm) next;
                C4123a c4123a = AudioCacheInfo.rUj;
                String str = bqm.wSV;
                C25052j.m39375o(str, "it.lyrics_content");
                C43665d c43665d = new C43665d(str, bqm.wSU, bqm.wSU);
                if (i2 > 0 && i2 < bql.wST.size()) {
                    ((C43665d) arrayList.get(i2 - 1)).snc = bqm.wSU;
                }
                arrayList.add(c43665d);
                i2 = i3;
            }
            audioCacheInfo.rTY.addAll(bql.wSS);
            audioCacheInfo.rTX = arrayList;
            String aaw = C29309l.aaw(bql.wSJ + '_' + C1839cb.aaE());
            audioCacheInfo.cachePath = aaw;
            if (C5730e.asZ(aaw) > 0) {
                z = true;
            } else {
                z = false;
            }
            audioCacheInfo.aIM = z;
            audioCacheInfo.rTZ = false;
            aaw = bql.wSR;
            C25052j.m39375o(aaw, "info.song_name");
            C25052j.m39376p(aaw, "<set-?>");
            audioCacheInfo.rUa = aaw;
            audioCacheInfo.type = i;
            C4990ab.m7416i(AudioCacheInfo.TAG, "LogStory: " + audioCacheInfo.rTW + ' ' + audioCacheInfo.rTX);
            AppMethodBeat.m2505o(109172);
            return audioCacheInfo;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, dWq = {"com/tencent/mm/plugin/story/model/audio/AudioCacheInfo$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.audio.AudioCacheInfo$b */
    public static final class C4124b implements Creator<AudioCacheInfo> {
        C4124b() {
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(109171);
            C25052j.m39376p(parcel, "parcel");
            AudioCacheInfo audioCacheInfo = new AudioCacheInfo(parcel);
            AppMethodBeat.m2505o(109171);
            return audioCacheInfo;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AudioCacheInfo[i];
        }
    }

    public AudioCacheInfo() {
        AppMethodBeat.m2504i(109174);
        this.rTY = new ArrayList();
        this.rUa = "";
        this.position = -1;
        this.rUb = -1;
        AppMethodBeat.m2505o(109174);
    }

    public AudioCacheInfo(Parcel parcel) {
        boolean z = true;
        C25052j.m39376p(parcel, "parcel");
        this();
        AppMethodBeat.m2504i(109175);
        this.rTW = parcel.readInt();
        this.musicUrl = parcel.readString();
        this.cachePath = parcel.readString();
        this.aIM = parcel.readByte() != (byte) 0;
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.rTZ = z;
        this.position = parcel.readInt();
        this.rUb = parcel.readLong();
        this.type = parcel.readInt();
        String readString = parcel.readString();
        C25052j.m39375o(readString, "parcel.readString()");
        this.rUa = readString;
        AppMethodBeat.m2505o(109175);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        byte b = (byte) 1;
        AppMethodBeat.m2504i(109173);
        C25052j.m39376p(parcel, "parcel");
        parcel.writeInt(this.rTW);
        parcel.writeString(this.musicUrl);
        parcel.writeString(this.cachePath);
        parcel.writeByte(this.aIM ? (byte) 1 : (byte) 0);
        if (!this.rTZ) {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeInt(this.position);
        parcel.writeLong(this.rUb);
        parcel.writeInt(this.type);
        parcel.writeString(this.rUa);
        AppMethodBeat.m2505o(109173);
    }

    public final int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.m2504i(109176);
        AppMethodBeat.m2505o(109176);
    }
}
