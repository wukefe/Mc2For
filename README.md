# Mc2For

---

Repository for the MATLAB to Fortran compiler

**Origin**:  [Sable/Mc2For](https://github.com/Sable/Mc2For)

**License**: [Read](LICENSE)

**Manual**: [Release notes](http://www.sable.mcgill.ca/mclab/projects/mc2for/)

Note: Only functions are supported (no scripts)

## Installation

The following command generates a jar file, `Mc2For.jar`.

```
cd languages/Natlab & ant jar-mc2for
```

Then, 

```
java -jar Mc2For.jar examples/simple.m -args "DOUBLE&1*1&REAL"  --codegen --pretty --outdir folder
```

The details of the command can be found as follow.

- `examples/simple.m`: source file(s)
- `-args "DOUBLE&1*1&REAL"`: type and shape of parameter(s)
- `--codegen`: generate FORTRAN code
- `--pretty`: pretty result with stdout
- `--outdir folder`: save result in a designated `folder`

\* Don't forget ***--codegen*** if you want to get FORTRAN code

More information can be found with the following command line.

```
java -jar Mc2For.jar -help
```


## Contact

Please send email to `mclab-list@sable.mcgill.ca` if you have any questions regarding the tool.