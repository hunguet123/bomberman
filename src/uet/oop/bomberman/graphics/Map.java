package uet.oop.bomberman.graphics;

import uet.oop.bomberman.GameViewManeger;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.SubClass.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.AbstractDocument.Content;

public class Map {

    public int createMap(int level) {
        File file = null;
        int posBomber = -1;
        Scanner scanner = null;
        URL url = getClass().getResource(Constant.BASE_MAP_URL + Integer.toString(level) + ".txt");
        file = new File(url.getFile());
        try {
            scanner = new Scanner(file);
            for (int i = 0; i < Constant.HEIGHT; i++) {
                for (int j = 0; j < Constant.WIDTH; j++) {GameViewManeger.stillObjects.add(new Grass(j, i, Sprite.grass));
                }
            }
          
            for (int i = 0; i < Constant.HEIGHT; i++) {
                String data = scanner.nextLine();
                for (int j = 0; j < Constant.WIDTH; j++) {
                    if(data.charAt(j) == Constant.MAP_WALL) {GameViewManeger.stillObjects.add(new Wall(j, i, Sprite.wall));
                    } else if (data.charAt(j) == Constant.MAP_PLAYER) {
                        posBomber = GameViewManeger.stillObjects.size();GameViewManeger.stillObjects.add(new Bomber(j, i, Sprite.player_right));
                    } else if (data.charAt(j) == Constant.MAP_BRICK) {GameViewManeger.stillObjects.add(new Brick(j, i, Sprite.brick));
                    } else if (data.charAt(j) == Constant.MAP_PORTAL) {GameViewManeger.stillObjects.add(new Portal(j, i, Sprite.portal));
                    } else if (data.charAt(j) == Constant.MAP_BOLLOOM) {GameViewManeger.stillObjects.add(new Balloon(j, i, Sprite.balloom_right1));
                    } else if (data.charAt(j) == Constant.MAP_ONEAL) {GameViewManeger.stillObjects.add(new Oneal(j ,i, Sprite.oneal_right1));
                    } else if (data.charAt(j) == Constant.MAP_BOMB_ITEM) {GameViewManeger.stillObjects.add(new BombItem(j, i, Sprite.bomb));
                    } else if (data.charAt(j) == Constant.MAP_POWER_UP) {GameViewManeger.stillObjects.add(new FlameItem(j, i, Sprite.powerup_flames));
                    } else if(data.charAt(j) == Constant.MAP_POWER_SPEED) {GameViewManeger.stillObjects.add(new SpeedItem(j, j, Sprite.powerup_speed));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("lỗi load map của level " + Integer.toString(level));
        }
        return posBomber;
    }

}
