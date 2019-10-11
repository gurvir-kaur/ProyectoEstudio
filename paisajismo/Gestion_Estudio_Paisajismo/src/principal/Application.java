package principal;

import java.util.Scanner;

/**
 *
 * @author root
 */
public class Application {
    
    private final static Scanner DADES = new Scanner(System.in);
    
    static private Estudi[] estudis = new Estudi[4];
    static private int posicioEstudis = 0;
    static private Estudi estudiActual = null;

    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Gestió d'estudis");
            System.out.println("\n2. Gestió de projectes");
            System.out.println("\n3. Gestió de dissenyadors o dissenyadores");
            System.out.println("\n4. Gestió de jardiners o jardineres");
            System.out.println("\n5. Gestió de torns");
            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    menuEstudis();
                    break;
                case 2:
                    if (estudiActual != null) {
                        menuProjectes();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar l'estudi al menú Gestió d'estudis");
                    }
                    break;
                case 3:
                    if (estudiActual != null) {
                        menuDissenyadors();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar l'estudi al menú Gestió d'estudis");
                    }
                    break;
                case 4:
                    if (estudiActual != null) {
                        menuJardiners();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar l'estudi al menú Gestió d'estudis");
                    }
                    break;
                case 5:
                    if (estudiActual != null) {
                        menuTorns();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar l'estudi al menú Gestió d'estudis");
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuEstudis() {
        int opcio = 0;

        do {
            int indexSel = -1;
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Seleccionar estudi");
            System.out.println("\n3. Modificar");
            System.out.println("\n4. Llista d'estudis");
            opcio = DADES.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    estudis[posicioEstudis] = Estudi.addEstudi();
                    posicioEstudis++;
                    break;
                case 2:
                    indexSel = selectEstudi();
                    if (indexSel >= 0) {
                        estudiActual = estudis[indexSel];
                    } else {
                        System.out.println("\nNo existeix aquest estudi");
                    }
                    break;
                case 3:
                    indexSel = selectEstudi();
                    if (indexSel >= 0) {
                        estudis[indexSel].updateEstudi();
                    } else {
                        System.out.println("\nNo existeix aquest estudi");
                    }
                    break;
                case 4:
                    for (int i = 0; i < posicioEstudis; i++) {
                        estudis[i].showEstudi();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    /*
     TODO Heu de desenvolupar el menuDissenyadors amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, l'atribut estudiActual no és null
       
     Opció 0. Sortir -->  Surt del menú i retorna al menú principal
     Opció 1. Alta -->  Crea un dissenyador en l'estudi actual. Penseu que Estudi sap crear dissenyadors o dissenyadores        
     Opció 2. Modificar -> Permet modificar un dissenyador o dissenyadora que està donat d'alta a l'estudi actual
     (per comprovar l'existència del dissenyador o dissenyadora tenim un mètode en la classe Estudi que ens ajuda)
     Opció 3. Llista de dissenyadors i dissenyadores -> Imprimeix les dades dels dissenyadors i dissenyadores de l'estudi actual
        
     A més, heu de fer una estructura iterativa per tornar a mostrar el menú sempre que no 
     es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch-case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable opcio de tipus enter
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, ja que això ho farem amb la
     tècnica de les excepcions que veurem més endavant
     */
    public static void menuDissenyadors() {
       int opcio = 0;

        do {
            
            System.out.println("\nSelecciona una opció");
            
            //Sortir -->  Surt del menú i retorna al menú principal
            System.out.println("\n0. Sortir");
            
            //Crea un dissenyador en l'estudi actual. 
            //Penseu que Estudi sap crear dissenyadors o dissenyadores        
            System.out.println("\n1. Alta");
            
            /*
             Permet modificar un dissenyador o dissenyadora que està donat 
            d'alta a l'estudi actual (per comprovar l'existència del dissenyador 
            o dissenyadora tenim un mètode en la classe Estudi que ens ajuda)
            */
            System.out.println("\n2. Modificar");
            /*
             Llista de dissenyadors i dissenyadores -> 
            Imprimeix les dades dels dissenyadors i dissenyadores de 
            l'estudi actual
            */
            System.out.println("\n3. Llista de Dissenyadors");
            
            opcio = DADES.nextInt();
            switch (opcio) {
                
                //salir
                case 0:
                    break;
                    
                    //añadir diseñador
                case 1:
                    estudiActual.addDissenyador();
                    break;
                    
                    //modificar
                case 2:
                    
                    int pos = estudiActual.selectDissenyador(null);
                    estudiActual.getDissenyadors()[pos].updateDissenyador();
                    break;
                    
                    //lista de diseñadors
                
                        case 3:
                    //getDissenyadors devuelve array de diseñadores.
                    //para imprimir todos los diseñadores se necesita un FOR
                    
                    for(int i = 0; i < estudiActual.getposicioDissenyadors(); i++){
                        estudiActual.getDissenyadors()[i].showDissenyador();
                    }
                    break;
                    
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    /*
     TODO Heu de desenvolupar el menuJardiners amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, l'atribut estudiActual no és null
     
     Opció 0. Sortir -->         Surt del menú i retorna al menú principal
     Opció 1. Alta -->           Crea un jardiner o jardinera en l'estudi actual. Penseu que Estudi sap crear jardiners
     o jardineres.        
     Opció 2. Modificar ->     Permet modificar un jardiner o jardinera que està donat d'alta a l'estudi actual
     (per comprovar l'existència del jardiner o jardinera tenim un mètode en la classe Estudi que ens ajuda)
     Opció 3. Assignar torn ->   Assigna un torn a un jardiner o jardinera, però penseu que Estudi sap com fer-ho.
     Opció 4. Llista de jardiners i jardineres-> Imprimeix les dades dels jardiners i jardineres de l'estudi actual.
        
     A més, heu de fer una estructura iterativa per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch-case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable opcio de tipus enter
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, ja que això ho farem amb la
     tècnica de les excepcions que veurem més endavant
     */
    public static void menuJardiners() {
       int opcio = 0;

        do {
            
            System.out.println("\nSelecciona una opció");
            
            //Sortir -->  Surt del menú i retorna al menú principal
            System.out.println("\n0. Sortir");
            
            //Crea un jardiner o jardinera en l'estudi actual        
            System.out.println("\n1. Alta");
            
            System.out.println("\n2. Modificar");
            
            System.out.println("\n3. Assignar torn");
            
            System.out.println("\n4. Llista de Jardiners");
            
            opcio = DADES.nextInt();
            switch (opcio) {
                
                //salir
                case 0:
                    break;
                    
                case 1:
                    estudiActual.addJardiner();
                    break;
                    
                    //modificar
                case 2:
                    
                    int pos = estudiActual.selectJardiner(null);
                    estudiActual.getJardiners()[pos].updateJardiner();
                    break;
                    
                    //Asignar turno
                case 3:
                    estudiActual.addTornJardiner();
                    break;
                    
                    //lista de jardineros
                case 4:
                    
                    for(int i = 0; i < estudiActual.getposicioJardiners(); i++){
                        estudiActual.getJardiners()[i].showJardiner();
                    }
                    break;
                    
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
        
    }

    /*
     TODO Heu de desenvolupar el menuTorns amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, l'atribut estudiActual no és null
     
     Opció 0. Sortir -->         Surt del menú i retorna al menú principal
     Opció 1. Alta -->           Crea un torn en l'estudi actual. Penseu que Estudi sap crear torns     
     Opció 2. Modificar ->     Permet modificar un torn que existeix a l'estudi actual
     (per comprovar l'existència del torn tenim un mètode en la classe Estudi que ens ajuda)
     Opció 3. Llista de torns-> Imprimeix les dades dels torns de l'estudi actual.
        
     A més, heu de fer una estructura iterativa per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch-case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable opcio de tipus enter
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, ja que això ho farem amb la
     tècnica de les excepcions que veurem més endavant
     */
    public static void menuTorns() {
       int opcio = 0;

        do {
            
            System.out.println("\nSelecciona una opció");
            
            //Sortir -->  Surt del menú i retorna al menú principal
            System.out.println("\n0. Sortir");
                   
            System.out.println("\n1. Alta");
            
            System.out.println("\n2. Modificar");
            
            System.out.println("\n3. LLista de Torns");
            
            opcio = DADES.nextInt();
            switch (opcio) {
                
                //salir
                case 0:
                    break;
                    
                case 1:
                    estudiActual.addTorn();
                    break;
                    
                    //modificar
                case 2:
                    
                    int pos = estudiActual.selectTorn(null);
                    estudiActual.getTorns()[pos].updateTorn();
                    break;
                    
                case 3:
                    for(int i = 0; i < estudiActual.getposicioTorns(); i++){
                        estudiActual.getTorns()[i].showTorn();
                    }
                    break;
                    
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
        
    }

    /*
     TODO Heu de desenvolupar el menuProjectes amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, l'atribut estudiActual no és null
     
     Opció 0. Sortir -->         Surt del menú i retorna al menú principal
     Opció 1. Alta -->           Crea un projecte en l'estudi actual. Penseu que Estudi sap crear projectes      
     Opció 2. Modificar ->     Permet modificar un projecte que existeix a l'estudi actual
     (per comprovar l'existència del projecte tenim un mètode en la classe Estudi que ens ajuda)
     Opció 3. Assignar dissenyador o dissenyadora ->   Assigna un dissenyador o dissenyadora a un projecte, però penseu que Estudi sap com fer-ho.
     Opció 4. Assignar jardiner o jardinera ->   Assigna un jardiner o jardinera a un projecte, però penseu que Estudi sap com fer-ho.
     Opció 5. Llista de projectes-> Imprimeix les dades dels projectes de l'estudi actual.
        
     A més, heu de fer una estructura iterativa per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch-case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable opcio de tipus enter
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, ja que això ho farem amb la
     tècnica de les excepcions que veurem més endavant
     */
    public static void menuProjectes() {
       int opcio = 0;

        do {
            
            System.out.println("\nSelecciona una opció");
            
            //Sortir -->  Surt del menú i retorna al menú principal
            System.out.println("\n0. Sortir");
                    
            System.out.println("\n1. Alta");
            
            System.out.println("\n2. Modificar");
            
            System.out.println("\n3. Assignar Dissenyador");
            
            System.out.println("\n4. Assignar Jardiner");
            
            System.out.println("\n5. LLista de Projectes");
            
            opcio = DADES.nextInt();
            switch (opcio) {
                
                //salir
                case 0:
                    break;
                    
                case 1:
                    estudiActual.addProjecte();
                    break;
                    
                    //modificar
                case 2:
                    
                    int pos = estudiActual.selectProjecte(null);
                    estudiActual.getProjectes()[pos].updateProjecte();
                    break;
                    
                case 3:
                    estudiActual.addDissenyadorProjecte();
                    break;
                
                case 4:
                    estudiActual.addJardinerProjecte();
                    break;
                    
                case 5:
                    for(int i = 0; i < estudiActual.getposicioProjectes(); i++){
                        estudiActual.getProjectes()[i].showProjecte();
                    }
                    break;
                    
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
       
    }

    public static Integer selectEstudi() {

        System.out.println("\nCodi de l'estudi?:");
        int codi = DADES.nextInt();

        for (int i = 0; i < posicioEstudis; i++) {
            if (estudis[i].getCodi() == codi) {
                return i;
            }
        }
        return -1;
    }

}
