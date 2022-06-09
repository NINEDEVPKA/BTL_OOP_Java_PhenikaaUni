/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setSizeImage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author zzgia
 */
public class setsize {

    public setsize(javax.swing.JLabel label, String imge) throws IOException {
        set( label, imge);
    }
    void set(javax.swing.JLabel label, String imge) throws IOException{
        try {
            BufferedImage img = ImageIO.read(new File("imge"));
            int x = label.getSize().width;
            int y = label.getSize().height;
            int ix = img.getWidth();
            int iy = img.getHeight();
            int dx = 0;
            int dy = 0;
            if(x/y >ix/iy){
                dy = y;
                dx = dy * ix/iy;
            }else{
                dx = x;
                dy = y;
            }
            ImageIcon icon = new ImageIcon(img.getScaledInstance(dy, dy, img.SCALE_SMOOTH));
            label.setIcon(icon);
        } catch (Exception e) {
        }
    }
}
