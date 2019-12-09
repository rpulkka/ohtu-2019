
package statistics.matcher;

public class QueryBuilder {
    private Matcher stack;
    
    public QueryBuilder() {
        stack = new All();
    }
    
    public Matcher build() {
        Matcher m = this.stack;
        this.stack = new All();
        return m;
    }

    public QueryBuilder playsIn(String team) {
        this.stack = new And(this.stack, new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int i, String category) {
        this.stack = new And(this.stack, new HasAtLeast(i, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int i, String category) {
        this.stack = new And(this.stack, new HasFewerThan(i, category));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher... matchers) {
        this.stack = new Or(matchers);
        return this;
    }
}
