package com.gmail.tomahawkmissile2.magicraft.command;

public enum Command {
	
	HELP("magicraft",new Argument[] {}),
	HELP2("magicraft",new Argument[] {new Argument("help")}),
	GUI("magicraft",new Argument[] {new Argument("gui")});
	
	//TODO: add commands.
	
	Argument[] args;
	String label;
	
	private Command(String label, Argument[] args) {
		this.args=args;
		this.label=label;
	}
	public Argument[] getArgs() {
		return args;
	}
	public String getLabel() {
		return label;
	}
	public Argument getArg(int index) {
		return args[index];
	}
	public boolean isValidCommand(String cmd, String[] args) {
		if(this.getLabel().equalsIgnoreCase(cmd)) {
			if((args.length==0||args==null)&&(this.getArgs()==null||this.getArgs().length==0)) {
				return true;
			}
			if(args.length==this.getArgs().length) {
				for(int i=0;i<args.length;i++) {
					if(this.getArg(i).isValidArgument(args[i])) {
						continue;
					} else {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
}
