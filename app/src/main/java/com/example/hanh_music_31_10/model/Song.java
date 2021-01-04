package com.example.hanh_music_31_10.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;

import com.example.hanh_music_31_10.ui.recycler.RecyclerData;

import java.util.HashSet;
import java.util.Objects;

public class Song implements RecyclerData {

    private int id;
    private String nameSong;
    private String pathSong;
    private String singer;
    private String albumID;
    private String duration;
    private int idCategory;
    private String imageUrl;
    private String linkUrl;

    public Song() {
        this(0, "", "", "", "", "");
    }

    public Song(int id, String nameSong, String pathSong, String singer, String albumID, String duration, int idCategory, String mImageUrl) {
        this(id, nameSong, pathSong, singer, albumID, duration, idCategory, mImageUrl, "");
    }

    public Song(int id, String nameSong, String pathSong, String singer, String albumID,
                String duration, int idCategory, String mImageUrl, String mLinkUrl) {
        this.id = id;
        this.nameSong = nameSong;
        this.pathSong = pathSong;
        this.singer = singer;
        this.albumID = albumID;
        this.duration = duration;
        this.idCategory = idCategory;
        this.imageUrl = mImageUrl;
        this.linkUrl = mLinkUrl;
    }

    //song offline
    public Song(int id, String nameSong, String imageUrl, String artist, String albumID, String timeSong) {
        this(id, nameSong, imageUrl, artist, albumID, timeSong, 0, "", "");
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getId() {
        return id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public String getPathSong() {
        return pathSong;
    }

    public String getSinger() {
        return singer;
    }

    public String getDuration() {
        return duration;
    }

    public String getAlbumID() {
        return albumID;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoryID(int id) {
        this.idCategory = id;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public void setAlbumID(String albumID) {
        this.albumID = albumID;
    }

    //lay anh theo bitmap neu co path
    public Bitmap loadImageFromPath(String path) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        byte[] data = mediaMetadataRetriever.getEmbeddedPicture();
        return data == null ? null : BitmapFactory.decodeByteArray(data, 0, data.length);
    }

    @Override
    public int getViewType() {
        return 0;
    }

    @Override
    public boolean areItemsTheSame(RecyclerData other) {
        if (other instanceof Song) {
            Song obj = (Song) other;
            return id == obj.id
                    && nameSong.equals(obj.nameSong)
                    && pathSong.equals(obj.pathSong)
                    && singer.equals(obj.singer)
                    && albumID.equals(obj.albumID)
                    && idCategory == obj.idCategory
                    && imageUrl.equals(obj.imageUrl)
                    && linkUrl.equals(obj.linkUrl);
        }
        return false;
    }

    @Override
    public boolean areContentsTheSame(RecyclerData other) {
        if (other instanceof Song) {
            Song obj = (Song) other;
            return id == obj.id
                    && nameSong.equals(obj.nameSong)
                    && pathSong.equals(obj.pathSong)
                    && singer.equals(obj.singer)
                    && albumID.equals(obj.albumID)
                    && idCategory == obj.idCategory
                    && imageUrl.equals(obj.imageUrl)
                    && linkUrl.equals(obj.linkUrl);
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return id == song.id &&
                idCategory == song.idCategory &&
                Objects.equals(nameSong, song.nameSong) &&
                Objects.equals(pathSong, song.pathSong) &&
                Objects.equals(singer, song.singer) &&
                Objects.equals(albumID, song.albumID) &&
                Objects.equals(duration, song.duration) &&
                Objects.equals(imageUrl, song.imageUrl) &&
                Objects.equals(linkUrl, song.linkUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameSong, pathSong, singer, albumID, duration, idCategory, imageUrl, linkUrl);
    }
}
