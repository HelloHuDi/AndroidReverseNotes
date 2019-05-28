package com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser;

import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.audioplaylist.AudioPlayListItemInfo;
import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.upstream.FileDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CueItemParser extends AudioPlayListItemParser {
    public static final String TAG = "CueItemParser";
    private LineNumberReader mReader;
    protected List<TrackInfo> mTrackInfoList = new LinkedList();

    public CueItemParser(String str) {
        AppMethodBeat.i(104772);
        this.mUri = str;
        AppMethodBeat.o(104772);
    }

    private long convertTimeStrToMs(String str) {
        AppMethodBeat.i(104773);
        String[] split = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        long parseLong = Long.parseLong(split[0]);
        long parseLong2 = Long.parseLong(split[1]);
        long parseLong3 = (Long.parseLong(split[2]) * 10) + (((parseLong * 60) + parseLong2) * 1000);
        AppMethodBeat.o(104773);
        return parseLong3;
    }

    public Iterator<TrackInfo> iterator() {
        AppMethodBeat.i(104774);
        Iterator it = this.mTrackInfoList.iterator();
        AppMethodBeat.o(104774);
        return it;
    }

    public boolean isParseSuccess() {
        AppMethodBeat.i(104775);
        if (this.mTrackInfoList.isEmpty()) {
            AppMethodBeat.o(104775);
            return false;
        }
        AppMethodBeat.o(104775);
        return true;
    }

    private String guessCharsetEncoding(String str) {
        AppMethodBeat.i(104776);
        Logger.i(TAG, "CueItemParser.guessCharsetEncoding, filePath: ".concat(String.valueOf(str)));
        String guessCharsetEncoding = guessCharsetEncoding(new FileInputStream(str));
        AppMethodBeat.o(104776);
        return guessCharsetEncoding;
    }

    public void parse() {
        Exception e;
        ParseException parseException;
        AppMethodBeat.i(104777);
        Logger.i(TAG, "CueItemParser.parse, uri: " + this.mUri);
        File file = new File(this.mUri);
        CharSequence charSequence = null;
        CharSequence charSequence2 = null;
        String str = null;
        Object obj = null;
        int i = 0;
        long j = 0;
        int i2 = 0;
        TrackInfo trackInfo = null;
        this.mTrackInfoList.clear();
        try {
            this.mReader = new LineNumberReader(new InputStreamReader(new FileInputStream(file), guessCharsetEncoding(this.mUri)));
            Object obj2 = null;
            int i3 = 0;
            while (true) {
                try {
                    String readLine = this.mReader.readLine();
                    i3 = this.mReader.getLineNumber();
                    int i4;
                    if (TextUtils.isEmpty(readLine)) {
                        if (!this.mTrackInfoList.isEmpty()) {
                            TrackInfo trackInfo2 = (TrackInfo) this.mTrackInfoList.get(this.mTrackInfoList.size() - 1);
                            if (!(j == 0 || trackInfo2.getRange() == null || ((Long) trackInfo2.getRange().second).longValue() != 0)) {
                                trackInfo2.setEndPostion(j);
                            }
                            i4 = 0;
                            while (true) {
                                i2 = i4;
                                if (i2 < this.mTrackInfoList.size()) {
                                    trackInfo2 = (TrackInfo) this.mTrackInfoList.get(i2);
                                    if (!TextUtils.isEmpty(charSequence) && TextUtils.isEmpty(trackInfo2.getAlbum())) {
                                        trackInfo2.setAlbum(charSequence);
                                    }
                                    if (!TextUtils.isEmpty(charSequence2) && TextUtils.isEmpty(trackInfo2.getPerformer())) {
                                        trackInfo2.setPerformer(charSequence2);
                                    }
                                    i4 = i2 + 1;
                                }
                            }
                            this.mReader.close();
                            AppMethodBeat.o(104777);
                            return;
                        }
                        try {
                            this.mReader.close();
                            AppMethodBeat.o(104777);
                            return;
                        } catch (Exception e2) {
                            Logger.e(TAG, "LineNumberReader close ex", e2);
                            AppMethodBeat.o(104777);
                            return;
                        }
                    }
                    IOException iOException;
                    TrackInfo trackInfo3;
                    Object obj3;
                    if (obj == null && readLine.trim().toUpperCase().startsWith("PERFORMER")) {
                        charSequence2 = AudioPlayListItemParser.delSeprator(readLine);
                    }
                    if (obj == null && readLine.trim().toUpperCase().startsWith(ShareConstants.TITLE)) {
                        charSequence = AudioPlayListItemParser.delSeprator(readLine);
                    }
                    if (readLine.trim().toUpperCase().startsWith("FILE")) {
                        if (obj != null) {
                            obj = null;
                        }
                        if (!(j == 0 || trackInfo == null)) {
                            trackInfo.setEndPostion(j);
                        }
                        String delSeprator = AudioPlayListItemParser.delSeprator(readLine);
                        String parent = file.getParent();
                        if (!parent.endsWith("/")) {
                            parent = parent + "/";
                        }
                        if (delSeprator.startsWith("/")) {
                            delSeprator = delSeprator.substring(1);
                        }
                        str = parent + delSeprator;
                        if (new File(str).exists()) {
                            long duration;
                            NativeDecoder nativeDecoder = new NativeDecoder();
                            i4 = nativeDecoder.init(new FileDataSource(str));
                            if (i4 == 0) {
                                duration = nativeDecoder.getAudioInformation().getDuration();
                            } else {
                                Logger.e(TAG, "media item in cue init fail! ret = " + i4 + " ,path: " + str);
                                duration = j;
                            }
                            nativeDecoder.release();
                            j = duration;
                        } else {
                            iOException = new IOException("media file in cue not exist! cue Path: " + this.mUri);
                            AppMethodBeat.o(104777);
                            throw iOException;
                        }
                    }
                    if (readLine.trim().toUpperCase().startsWith("TRACK")) {
                        trackInfo3 = new TrackInfo(AudioPlayListItemInfo.TYPE_CUE);
                        trackInfo3.setFilePath(str);
                        obj = 1;
                        i++;
                    } else {
                        trackInfo3 = trackInfo;
                    }
                    if (obj != null && readLine.trim().toUpperCase().startsWith(ShareConstants.TITLE)) {
                        trackInfo3.setTitle(AudioPlayListItemParser.delSeprator(readLine));
                    }
                    if (obj != null && readLine.trim().toUpperCase().startsWith("PERFORMER")) {
                        trackInfo3.setPerformer(AudioPlayListItemParser.delSeprator(readLine));
                    }
                    if (i == 1 && readLine.trim().toUpperCase().startsWith("INDEX")) {
                        if (readLine.trim().contains(" 01 ")) {
                            trackInfo3.setStartPosition(convertTimeStrToMs(readLine.trim().split(" 01 ")[1].trim()));
                        } else {
                            iOException = new IOException("first item in CUE must only have feature \"INDEX 01\"!");
                            AppMethodBeat.o(104777);
                            throw iOException;
                        }
                    }
                    if (i < 2 || !readLine.trim().toUpperCase().startsWith("INDEX")) {
                        obj3 = obj2;
                    } else if (readLine.trim().contains(" 00 ")) {
                        ((TrackInfo) this.mTrackInfoList.get(i - 2)).setEndPostion(convertTimeStrToMs(readLine.trim().split(" 00 ")[1].trim()));
                        obj3 = 1;
                    } else if (readLine.trim().contains(" 01 ")) {
                        String trim = readLine.trim().split(" 01 ")[1].trim();
                        trackInfo3.setStartPosition(convertTimeStrToMs(trim));
                        if (obj2 == null) {
                            ((TrackInfo) this.mTrackInfoList.get(i - 2)).setEndPostion(convertTimeStrToMs(trim));
                        }
                        obj3 = obj2;
                    } else {
                        iOException = new IOException("item " + i + " in CUE have illegel feature \"INDEX\"!");
                        AppMethodBeat.o(104777);
                        throw iOException;
                    }
                    if (i > 0 && readLine.trim().toUpperCase().startsWith("INDEX") && readLine.trim().contains(" 01 ")) {
                        this.mTrackInfoList.add(trackInfo3);
                        trackInfo3 = new TrackInfo(AudioPlayListItemInfo.TYPE_CUE);
                        trackInfo3.setFilePath(str);
                        obj3 = null;
                    }
                    obj2 = obj3;
                    trackInfo = trackInfo3;
                } catch (IOException e3) {
                    e = e3;
                    i2 = i3;
                    try {
                        parseException = new ParseException("Parse Exception occured", e, i2);
                        AppMethodBeat.o(104777);
                        throw parseException;
                    } catch (Throwable th) {
                        try {
                            this.mReader.close();
                        } catch (Exception e4) {
                            Logger.e(TAG, "LineNumberReader close ex", e4);
                        }
                        AppMethodBeat.o(104777);
                    }
                }
            }
        } catch (IOException e5) {
            e = e5;
            parseException = new ParseException("Parse Exception occured", e, i2);
            AppMethodBeat.o(104777);
            throw parseException;
        }
    }
}
