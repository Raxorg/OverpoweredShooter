package touchables;


import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import player.Player;


public class Wall {

    Rectangle hitBox = new Rectangle(100, 100, 70, 100);



    public void draw(ShapeRenderer renderer) {
        renderer.rect(hitBox.x, hitBox.y, hitBox.width, hitBox.height);
    }

    public void wall(Player player) {
        if (!hitBox.overlaps(player.hitBox))
            return;
        Rectangle e = player.hitBox;

        float overlapLeft = (e.x + e.width) - hitBox.x;
        float overlapRight = (hitBox.x + hitBox.width) - e.x;
        float overlapBottom = (e.y + e.height) - hitBox.y;
        float overlapTop = (hitBox.y + hitBox.height) - e.y;

        float minOverlapX = Math.min(overlapLeft, overlapRight);
        float minOverlapY = Math.min(overlapBottom, overlapTop);

        if (minOverlapX < minOverlapY) {
            e.x += (overlapLeft < overlapRight) ? -minOverlapX : minOverlapX;
            return;
        }
        e.y += (overlapBottom < overlapTop) ? -minOverlapY : minOverlapY;
    }
}

