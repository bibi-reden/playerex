package git.clevernucleus.playerex.api.element;

import net.minecraft.nbt.CompoundNBT;

public interface IPlayerElements {
	
	/**
	 * @param par0 Input element.
	 * @return Gets the input elements data from the input element's getFunction.
	 */
	float get(Element par0);
	
	/**
	 * Changes the value of the input element (Equivalent to an adder/setter).
	 * @param par0 Input element.
	 * @param par1 Add value.
	 */
	void add(Element par0, float par1);
	
	/**
	 * Forcefully sets the input Element to the input value without affecting other elements, provided that the input element is of {@link Element.Type#ALL} or {@link Element.Type#DATA}.
	 * @param par0 Input element.
	 * @param par1 Input value.
	 */
	void set(Element par0, float par1);
	
	/**
	 * Writes capability data to a tag.
	 * @return A tag with the capability data.
	 */
	CompoundNBT write();
	
	/**
	 * Reads the data from the input tag to the capability.
	 * @param par0 Input tag.
	 */
	void read(CompoundNBT par0);
}