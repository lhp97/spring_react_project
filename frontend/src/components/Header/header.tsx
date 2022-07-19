import logo from '../../assets/img/logo.svg'

import './header.css'

function Header() {
    return (
        <header>
            <div className="dsmeta-logo-container">
                <img src={logo} alt="DSMeta" />
                <h1>Projeto - Spring + React</h1>
                <p>
                    Desenvolvido por
                    <a href="https://www.linkedin.com/in/luis-henrique-do-prado-364389123/"> @luisHenrique</a>
                </p>
            </div>
        </header>
    )
}

export default Header;