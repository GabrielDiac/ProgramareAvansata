import Entity.AlbumEntity;
import Entity.ArtistEntity;
import Util.PersistenceUtil;

import java.lang.management.ManagementFactory;
import java.sql.*;
import java.util.List;
import javax.persistence.EntityManager;
import Entity.AlbumEntity;
import repo.AlbumRepository;
import repo.ArtistRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main{
    public static void main(String args[]){

        try{

            PersistenceUtil pu=PersistenceUtil.getInstance();
            ArtistRepository repositoryArtist1 = new ArtistRepository(pu);
            ArtistEntity artist1 = new ArtistEntity();
            artist1.setId(20);
            artist1.setName("Weeknd2");
            artist1.setCountry("US2");
            repositoryArtist1.create(artist1);

            ArtistRepository repositoryArtist2 = new ArtistRepository(pu);
            ArtistEntity artist2 = new ArtistEntity();
            artist2.setId(21);
            artist2.setName("Weeknd3");
            artist2.setCountry("US3");
            repositoryArtist2.create(artist2);

            System.out.println(repositoryArtist2.findbyId(21));

            List<ArtistEntity> listArtists=repositoryArtist2.findByName("Weeknd2");
            for (ArtistEntity albumFor : listArtists) {
                System.out.println(albumFor);
            }


          AlbumRepository repositoryAlbum1 = new AlbumRepository(pu);
            AlbumEntity album1= new AlbumEntity();
            album1.setId(23);
            album1.setArtistId(21);
            album1.setName("ALBUM1");
            album1.setReleaseYear(2222);
            repositoryAlbum1.create(album1);
            System.out.println(repositoryAlbum1.findbyId(23));
            List<AlbumEntity> listAlbums=repositoryAlbum1.findByName("ALBUM1");
            for (AlbumEntity albumFor : listAlbums) {
                System.out.println(albumFor);
            }


            List<AlbumEntity> listAlbums2=repositoryAlbum1.findByArtist(21);
            for (AlbumEntity albumFor : listAlbums2) {
                System.out.println(albumFor);
            }


        }catch(Exception e){ System.out.println(e);}
    }
}  