package clevernucleus.playerex.common.init.element;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.util.TriConsumer;

import clevernucleus.playerex.common.init.capability.IPlayerElements;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;

/**
 * Basic implementation of IElement.
 */
public class PropertyElement implements IDataElement {
	private String key;
	private float defaultValue, minValue, maxValue;
	private TriConsumer<PlayerEntity, IPlayerElements, Double> adder;
	
	/**
	 * Constructor.
	 * @param par0 Key.
	 * @param par1 Default value.
	 * @param par2 Minimum value.
	 * @param par3 Maximum value.
	 * @param par4 Adder.
	 */
	public PropertyElement(final @Nonnull String par0, final @Nonnull float par1, final @Nonnull float par2, final @Nonnull float par3, final @Nonnull TriConsumer<PlayerEntity, IPlayerElements, Double> par4) {
		this.key = par0;
		this.defaultValue = par1;
		this.minValue = par2;
		this.maxValue = par3;
		this.adder = par4;
		
		this.init(this);
	}
	
	/**
	 * @return This element's minimum value.
	 */
	public float minValue() {
		return this.minValue;
	}
	
	/**
	 * @return This element's maximum value.
	 */
	public float maxValue() {
		return this.maxValue;
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
