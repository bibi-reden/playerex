package clevernucleus.playerex.common.init.element;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.util.TriConsumer;

import clevernucleus.playerex.common.init.capability.IPlayerElements;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;

/**
 * Basic implementation of IElement.
 */
public class WritableElement implements IDataElement {
	private String key;
	private float defaultValue;
	private TriConsumer<PlayerEntity, IPlayerElements, Double> adder, setter;
	
	/**
	 * Constructor.
	 * @param par0 Key.
	 * @param par1 Default Value.
	 * @param par2 Adder.
	 * @param par3 Setter.
	 */
	public WritableElement(final @Nonnull String par0, final @Nonnull float par1, final @Nonnull TriConsumer<PlayerEntity, IPlayerElements, Double> par2, final @Nonnull TriConsumer<PlayerEntity, IPlayerElements, Double> par3) {
		this.key = par0;
		this.defaultValue = par1;
		this.adder = par2;
		this.setter = par3;
		
		this.init(this);
	}
	
	@Override
	public float defaultValue() {
		return this.defaultValue;
	}
	
	@Override
	public double get(final PlayerEntity par0, final IPlayerElements par1) {
		return this.defaultValue;
	}
	
	@Override
	public void set(final PlayerEntity par0, final IPlayerElements par1, final double par2) {
		this.setter.accept(par0, par1, par2);
	}
	
	@Override
	public void add(final PlayerEntity par0, final IPlayerElements par1, final double par2) {
		this.adder.accept(par0, par1, par2);
	}

	@Override
	public void writeDefault(final CompoundNBT par0) {
		par0.putFloat(this.key, this.defaultValue);
	}
	
	@Override
	public String toString() {
		return this.key;
	}
}
