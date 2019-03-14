package com.mygdx.son;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.joints.MouseJoint;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.Iterator;

public class PandaBesleme extends ApplicationAdapter {


	private static final Object MouseEvent = 3;


	private SpriteBatch oyunsayfası;
	private OrthographicCamera hareketlicamera;
	private TextureRegion arkaplan;
	private FileHandle pandafile;
	private float pandahız;
	private float gecenzaman = 0;
	private TextureRegion bug;
	private float bugpozisyonx;
	private float bugpozisyony;

	public Oyundurumu getOyundurumu() {
		return oyundurumu;
	}

	public void setOyundurumu(Oyundurumu oyundurumu) {
		this.oyundurumu = oyundurumu;
	}


	private enum Oyundurumu {Start, Running, Gameover,yeniden}

	;
	private Oyundurumu oyundurumu = Oyundurumu.Start;
	private static final float pandabas_x_konum = -30;
	private static final float pandabas_y_konum = 240;
	public Vector2 pandapozisyon;
	public Texture GURSUN;
	final float game_world_width = 800;
	final float game_world_height = 400;
	public MouseEvent tus;

	private enum Oyundurum {Start, Running, Gameover}

	;

	private Vector2 YerCekimi = new Vector2 ( );
	private Vector2 pandayercekimi = new Vector2 ( );

	private static final float hız = 200;
	private static final float zıplama = 350;
	private static final float yercekimi = -20;
	private float arkaplanpozX = 0;
	private float arkaplanpozY = 0;
	private Vector2 arkaplanpoz;
	private Vector2 kursunpozisyon;
	private float kursunX;
	private float kursunY;
	private Animation kursunn;
	private Array yuva;
	private Array <Rectangle> damlalar;
	private long sondamlamazamanı;
	private Rectangle panda;


	private TextureRegion arka;
	private Sound damlases;
	private Vector3 mouse_position;
	private Texture panta;
	private MouseJoint mousehareket;
	private Object processor;
	private int pandax = 0;
	private int panday = 20;
	public TextButton play;
	public Texture playresim;
	public ImageButton playButton;
	public TextButton btnPlay;
	public TextButton.TextButtonStyle textButtonStyle;
	public TextureRegion plaY;

	private enum Oyundurumum {Start,Running, Gameover}

	;

	private final Vector2 mouseInWorld2D = new Vector2 ( );
	private final Vector3 mouseInWorld3D = new Vector3 ( );
	public Button buton;
	public Skin skin;
	public int yeni;

	private Image backgroundImage;
	private TextButton playBButton, highScoreButton, aboutusButton;
	private BitmapFont CourierNew;
	public EventListener Listener;
	public int sayi1 = 80;
	public int sayi2 = 70;
	public Game game;
	public int fontX = 60;
	public int fontY = 80;
	public Table table;
	public Stage stage;
	public BitmapFont font;
	public Skin skinButton;
	public TextureAtlas buttonAtlas;
	public TextButton button;
	public OrthographicCamera arayüzkamera;
	public Texture pandaa;
	private Texture myTexture;
	private TextureRegion myTextureRegion;
	private TextureRegionDrawable myTexRegionDrawable;
	public  BitmapFont font1;
	public Skin skinButton1;
	public TextureAtlas buttonAtlas1;
	public TextButton button1;
	public TextButton.TextButtonStyle textButtonStyle1;
	public int puan;
	public BitmapFont font2;
    public  BitmapFont font3;
    public Skin skinButton3;
    public TextureAtlas buttonAtlas3;
    public TextButton button3;
    public TextButton.TextButtonStyle textButtonStyle3;
    public int enyuksek;
    public int can;
    public int sonuc;
    public BitmapFont font4;
    public  BitmapFont font5;
    public Skin skinButton5;
    public TextureAtlas buttonAtlas5;
    public TextButton button5;
    public TextButton.TextButtonStyle textButtonStyle5;
    public Stage stage2;
    public Table table1;
    public Vector3 dokunmapozisyonu;



    public InputMultiplexer inputMultiplexer;
	public void create() {


		pandaa = new Texture ( "pandaa.png" );

		font5=new BitmapFont ( Gdx.files.internal ( "fnt1.fnt" ) );
        font2 = new BitmapFont(Gdx.files.internal("saaa.fnt"));
        font4=new BitmapFont ( Gdx.files.internal ( "saglik.fnt" ) );


		font = new BitmapFont ( );
		skinButton = new Skin ( );
		buttonAtlas = new TextureAtlas ("button.txt");
		skinButton.addRegions ( buttonAtlas );
		textButtonStyle = new TextButton.TextButtonStyle ( );
		textButtonStyle.font = font;

		textButtonStyle.up = skinButton.getDrawable ( "rounded_rectangle_button" );
		textButtonStyle.down = skinButton.getDrawable ( "rounded_rectangle_button" );
		textButtonStyle.checked = skinButton.getDrawable ( "rounded_rectangle_button" );

		button=new TextButton("",textButtonStyle);
        button.setHeight ( 100 );
        button.setWidth ( 200 );
        button.setPosition ( 500,240 );
        stage=new Stage (  );
        stage.addActor ( button );

        font1 = new BitmapFont ( );
        skinButton1 = new Skin ( );
        buttonAtlas1 = new TextureAtlas ("y.txt");
        skinButton1.addRegions ( buttonAtlas1 );
        textButtonStyle1 = new TextButton.TextButtonStyle ( );
        textButtonStyle1.font = font1;
        can=3;

        textButtonStyle1.up = skinButton1.getDrawable ( "rounded_rectangle_button" );
        textButtonStyle1.down = skinButton1.getDrawable ( "rounded_rectangle_button" );
        textButtonStyle1.checked = skinButton1.getDrawable ( "rounded_rectangle_button" );

        button1=new TextButton("",textButtonStyle1);
        button1.setText ( "" );
        puan=0;


		button1.setText("");
		button1.setHeight(100);
		button1.setWidth(200);
		button1.setPosition(500,150);
        font3 = new BitmapFont ( );
        skinButton3 = new Skin ( );
        buttonAtlas3 = new TextureAtlas ("k.txt");
        skinButton3.addRegions ( buttonAtlas3 );
        textButtonStyle3 = new TextButton.TextButtonStyle ( );
        textButtonStyle3.font = font3;

        textButtonStyle3.up = skinButton3.getDrawable ( "rounded_rectangle_button" );
        textButtonStyle3.down = skinButton3.getDrawable ( "rounded_rectangle_button" );
        textButtonStyle3.checked = skinButton3.getDrawable ( "rounded_rectangle_button" );

        button3=new TextButton("",textButtonStyle3);
        button3.setText ( "" );

        button3.setHeight(100);
        button3.setWidth(210);
        button3.setPosition(500,100);



        stage2=new Stage();




		stage.addActor ( button1 );
		stage2.addActor ( button3 );
        button3.addListener ( new ClickListener ( ) {
            @Override
            public void clicked(InputEvent event , float x , float y) {
              if((oyundurumu == Oyundurumu.Gameover)) {
                  oyundurumu = Oyundurumu.yeniden;

                  System.out.println ( "ss" );
                  // game.getSoundManager().play( TyrianSound.CLICK );
              }



            }
        });



		button.addListener ( new ClickListener ( ) {
			@Override
			public void clicked(InputEvent event , float x , float y) {
				System.out.println ( "hiii" );


                if((oyundurumu == Oyundurumu.Start)){
                    oyundurumu = Oyundurumu.Running;
                }



		} });
        button1.addListener ( new ClickListener ( ) {
            @Override
            public void clicked(InputEvent event , float x , float y) {



                Gdx.app.exit ();


            }});









        Preferences prefs = Gdx.app.getPreferences("game preferences");














		arayüzkamera = new OrthographicCamera ( );
		arayüzkamera.setToOrtho ( false , Gdx.graphics.getWidth ( ) , Gdx.graphics.getHeight ( ) );

		arayüzkamera.update ( );


		oyunsayfası = new SpriteBatch ( );
		hareketlicamera = new OrthographicCamera ( );
		hareketlicamera.setToOrtho ( false , 800 , 480 );


		arkaplanpozX = 0;

		arkaplanpozY = 0;


		arka = new TextureRegion ( new Texture ( "arkaaplan.png" ) );


		bug = new TextureRegion ( new Texture ( "pandason.png" ) );
		panta = new Texture ( "boyut.png" );


		pandapozisyon = new Vector2 ( );



		float pandahız = 10.0f;
		bugpozisyonx = pandabas_x_konum;
		bugpozisyony = pandabas_y_konum;
		GURSUN = new Texture ( "gursun.png" );
		damlalar = new Array <Rectangle> ( );
		kursunn = new Animation ( +2.05f , new TextureRegion ( GURSUN ) , new TextureRegion ( GURSUN ) , new TextureRegion ( GURSUN ) );
		damlases = Gdx.audio.newSound ( Gdx.files.internal ( "g.mp3" ) );



		panda = new Rectangle ( );
        panda.width = 100;
        panda.height = 80;
		panda.x = 0;
		panda.y = 0;
		InputMultiplexer inputMultiplexer = new InputMultiplexer();
		inputMultiplexer.addProcessor(stage);
		inputMultiplexer.addProcessor(stage2);
		Gdx.input.setInputProcessor(inputMultiplexer);







		kursunn.setPlayMode ( Animation.PlayMode.LOOP );

		kursunX = bugpozisyonx + 10;
		kursunY = 100;


		dunyayıresetle ( );
		damlaüret ( );



	}


	private void damlaüret() {
		Rectangle rtcdamla = new Rectangle ( );
		rtcdamla.width = 200;
		rtcdamla.height = 100;
		rtcdamla.y = MathUtils.random ( 0 , 480 - 100 );
		rtcdamla.x = 800;
		damlalar.add ( rtcdamla );
		sondamlamazamanı = TimeUtils.nanoTime ( );
        System.out.println (enyuksek);


	}


	public void render() {


		hareketlicamera.update ( );
		dunyayigüncelle ( );




		dunyayicizdir ( );


	}


	public void dunyayıresetle() {


		YerCekimi.set ( 0 , yercekimi );
		pandayercekimi.set ( pandabas_x_konum , pandabas_y_konum );


	}


	private void dunyayigüncelle() {


		float deltaTime = Gdx.graphics.getDeltaTime ( );
		gecenzaman = gecenzaman + deltaTime;
		mouseInWorld3D.x = Gdx.input.getX ( );
		mouseInWorld3D.y = Gdx.input.getY ( );
		mouseInWorld3D.z = 0;
		hareketlicamera.unproject ( mouseInWorld3D );
		mouseInWorld2D.x = mouseInWorld3D.x;
		mouseInWorld2D.y = mouseInWorld3D.y;





	}


	public void dunyayicizdir() {


        hareketlicamera.update ( );

        oyunsayfası.setProjectionMatrix ( hareketlicamera.combined );

        oyunsayfası.begin ( );


        if (( oyundurumu == Oyundurumu.Start )) {
            oyunsayfası.end ();
            oyunsayfası.begin ();


            stage.getBatch ( ).begin ( );
            stage.getBatch ( ).draw ( pandaa , 0 , 0 ,Gdx.graphics.getWidth (),Gdx.graphics.getHeight ());


            stage.getBatch ( ).end ( );
            stage.draw ( );


        }


        if (( oyundurumu == Oyundurumu.Running )) {
            oyunsayfası.end ();
            oyunsayfası.begin ();

            if (puan > enyuksek) {
                enyuksek = puan;
                Preferences prefs = Gdx.app.getPreferences ( "game preferences" );

                prefs.putInteger ( "enyuksek" , enyuksek );

                enyuksek = prefs.getInteger ( "enyuksek" , enyuksek );

                prefs.flush ( );

            }


            button1.setTouchable ( Touchable.disabled );


            if (TimeUtils.nanoTime ( ) - sondamlamazamanı > 1000000000) {
                damlaüret ( );
            }
            Iterator <Rectangle> damla = damlalar.iterator ( );
            while (damla.hasNext ( )) {
                Rectangle rtcdamla = damla.next ( );
                rtcdamla.x -= 300 * Gdx.graphics.getDeltaTime ( );
                if (rtcdamla.x + 200 < 0) {
                    damla.remove ( );
                }
                if (rtcdamla.overlaps ( panda )) {
                    damlases.play ( );
                    damla.remove ( );
                    puan++;

                }
                if (rtcdamla.x < -200) {
                    can--;

                }


            }

            oyunsayfası.draw ( arka , arkaplanpozY , arkaplanpozY);

            oyunsayfası.draw ( panta , panda.x , panda.y );
            for (Rectangle rtcDamla : damlalar) {
                oyunsayfası.draw ( GURSUN , rtcDamla.x , rtcDamla.y );
                if (Gdx.input.isTouched ( )) {
                    Vector3 dokunmapozisyonu= new Vector3 (  );
                    dokunmapozisyonu.set ( Gdx.input.getX (),Gdx.input.getY (  ),0 );
                    hareketlicamera.unproject ( dokunmapozisyonu );



                    panda.y =dokunmapozisyonu.y-panda.height/2;
                    if(panda.y<0){
                        panda.y=0;
                    }
                    if(panda.y>370){
                        panda.y=370;
                    }


                }


            }
            font2.draw ( oyunsayfası , "Skorunuz:" + puan , 120 , 460 );
            font4.draw ( oyunsayfası , "Kalan Can:" + can , 30 , 460 );
            if(can<0){
                oyundurumu =Oyundurumu.Gameover;
            }
        }


        if((oyundurumu ==Oyundurumu.Gameover)){

                 oyunsayfası.end ();
                 oyunsayfası.begin ();

                 button.setTouchable ( Touchable.enabled );


                stage2.getBatch ( ).begin ( );
                stage2.getBatch ( ).draw ( pandaa , 0 , 0 ,Gdx.graphics.getWidth (),Gdx.graphics.getHeight ());



                stage2.getBatch ( ).end ( );
                stage2.draw ( );
                oyunsayfası.end ();
                oyunsayfası.begin ();
                sonuc = puan;
                font5.draw ( oyunsayfası,"Malesef Kaybettiniz Skorunuz:"+sonuc,500 ,320 );








                damlases.pause ( );
                damlalar.clear ( );
                sonuc--;

                if(button3.isPressed ()){
                    oyundurumu=Oyundurumu.yeniden;
                    can=3;
                    puan=0;
                }
            }if((oyundurumu==Oyundurumu.yeniden)){
                oyunsayfası.end ();
                oyunsayfası.begin ();


            if (puan > enyuksek) {
                enyuksek = puan;
                Preferences prefs = Gdx.app.getPreferences ( "game preferences" );

                prefs.putInteger ( "enyuksek" , enyuksek );

                enyuksek = prefs.getInteger ( "enyuksek" , enyuksek );

                prefs.flush ( );

            }


            button1.setTouchable ( Touchable.disabled );


            if (TimeUtils.nanoTime ( ) - sondamlamazamanı > 1000000000) {
                damlaüret ( );
            }
            Iterator <Rectangle> damla = damlalar.iterator ( );
            while (damla.hasNext ( )) {
                Rectangle rtcdamla = damla.next ( );
                rtcdamla.x -= 300 * Gdx.graphics.getDeltaTime ( );
                if (rtcdamla.x + 200 < 0) {
                    damla.remove ( );
                }
                if (rtcdamla.overlaps ( panda )) {
                    damlases.play ( );
                    damla.remove ( );
                    puan++;

                }
                if (rtcdamla.x < -200) {
                    can--;

                }


            }

            oyunsayfası.draw ( arka , arkaplanpozY , arkaplanpozY);

            oyunsayfası.draw ( panta , panda.x , panda.y );
            for (Rectangle rtcDamla : damlalar) {
                oyunsayfası.draw ( GURSUN , rtcDamla.x , rtcDamla.y );
                if (Gdx.input.isTouched ( )) {
                    Vector3 dokunmapozisyonu= new Vector3 (  );
                    dokunmapozisyonu.set ( Gdx.input.getX (),Gdx.input.getY (  ),0 );
                    hareketlicamera.unproject ( dokunmapozisyonu );



                    panda.y =dokunmapozisyonu.y-panda.height/2;
                    if(panda.y<0){
                        panda.y=0;
                    }
                    if(panda.y>370){
                        panda.y=370;
                    }


                }


            }
            font2.draw ( oyunsayfası , "Skorunuz:" + puan , 120 , 460 );
            font4.draw ( oyunsayfası , "Kalan Can:" + can , 30 , 460 );
            if(can<0){
                oyundurumu =Oyundurumu.Gameover;
            }

        }





           oyunsayfası.end ();



    }
					}


