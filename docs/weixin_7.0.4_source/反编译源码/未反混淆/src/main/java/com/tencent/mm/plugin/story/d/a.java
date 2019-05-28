package com.tencent.mm.plugin.story.d;

import a.l;
import com.tencent.mm.plugin.story.h.j;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/story/contract/AlbumContract;", "", "IFavAlbumPresenter", "IFavAlbumView", "IFavSelectPresenter", "IFavSelectView", "IPresenter", "IView", "plugin-story_release"})
public interface a {

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001e\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "", "onIsAll", "", "onLoadFavFinish", "datas", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "isAllEmpty", "", "plugin-story_release"})
    public interface b {
        void cxn();

        void f(List<j> list, boolean z);
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0016\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "", "onIsAll", "", "onLoadFinish", "datas", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "plugin-story_release"})
    public interface d {
        void cxn();

        void du(List<j> list);
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumPresenter;", "", "loadFavStoryFromDB", "", "loadFpData", "loadNpData", "onCreate", "userName", "", "onDestory", "plugin-story_release"})
    public interface a {
        void bMO();

        void cxk();

        void cxl();

        void cxm();

        void onCreate(String str);
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\"\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH&¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectPresenter;", "", "loadDBData", "", "loadFpData", "loadNpData", "onCreate", "userName", "", "onDestory", "setFavorite", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "favorite", "", "replaced", "plugin-story_release"})
    public interface c {
        void a(j jVar);

        void bMO();

        void cxk();

        void cxl();

        void cxo();

        void onCreate(String str);
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/contract/AlbumContract$IPresenter;", "", "checkStoryPost", "", "loadDBData", "loadFpData", "loadNpData", "onCreate", "userName", "", "onDestory", "plugin-story_release"})
    public interface e {
        void bMO();

        void cxk();

        void cxl();

        void cxo();

        void onCreate(String str);
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0016\u0010\u0005\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0016\u0010\t\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007H&¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "", "onBubbleFail", "", "onIsAll", "onLoadFinish", "datas", "", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "onStoryPostFail", "list", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "plugin-story_release"})
    public interface f {
        void cxn();

        void du(List<com.tencent.mm.plugin.story.ui.album.c> list);
    }
}
