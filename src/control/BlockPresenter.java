package control;

import model.Block;
import view.BlockDisplay;
import view.BlockDisplay.Moved;

public class BlockPresenter implements Block.Observer {
    private final Block block;
    private final BlockDisplay blockDisplay;

    public BlockPresenter(Block block, BlockDisplay blockDisplay) {
        this.block = block;
        this.blockDisplay = blockDisplay;
        this.blockDisplay.on(new Moved() {
            @Override
            public void to(int x, int y) {
                block.moveTo((x+1) / BlockDisplay.SIZE + 1, Block.MAX-y / BlockDisplay.SIZE);
            }
        });
        
        this.block.register(this);
        this.refresh();
    }

    private void refresh() {
        blockDisplay.paintBlock((block.x()-1)*BlockDisplay.SIZE, (Block.MAX - block.y())*BlockDisplay.SIZE);
    }

    @Override
    public void changed() {
        refresh();
    }
}
