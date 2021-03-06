package org.faudroids.mrhyde.auth;

import com.google.common.base.Objects;

/**
 * A single authenticated account (e.g. GitHub, Bitbucket, etc.).
 */
public abstract class Account {

  private final String login, email;

  public Account(String login, String email) {
    this.login = login;
    this.email = email;
  }

  public String getLogin() {
    return login;
  }

  public String getEmail() {
    return email;
  }

  public abstract <P, R> R accept(AccountVisitor<P, R> visitor, P param);

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Account)) return false;
    Account account = (Account) o;
    return Objects.equal(login, account.login) &&
        Objects.equal(email, account.email);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(login, email);
  }
}
