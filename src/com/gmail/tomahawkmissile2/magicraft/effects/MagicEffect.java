package com.gmail.tomahawkmissile2.magicraft.effects;

public class MagicEffect {

	MagicEffectType t;
	
	public enum MagicEffectType {
		EXTRA_HEALTH;
	}
	public MagicEffect(MagicEffectType type) {
		this.t=type;
	}
	public String getName() {
		return this.t.toString().toUpperCase();
	}
}
